package com.capstone.danjinae.user.controller;

import com.capstone.danjinae.notice.DTO.NoticeRequest;
import com.capstone.danjinae.notice.entity.Notice;
import com.capstone.danjinae.user.DTO.AddUserRequest;
import com.capstone.danjinae.user.DTO.AptListResponse;
import com.capstone.danjinae.user.DTO.AuthoUserRequest;
import com.capstone.danjinae.user.DTO.LoginUserRequest;
import com.capstone.danjinae.user.DTO.UserRequest;
import com.capstone.danjinae.user.JWT.service.JwtService;
import com.capstone.danjinae.user.entity.Apartment;
import com.capstone.danjinae.user.entity.User;
import com.capstone.danjinae.user.service.ApartService;
import com.capstone.danjinae.user.service.LoginService;
import com.capstone.danjinae.user.service.UserService;
import com.capstone.danjinae.vehicle.entity.Vehicle;
import com.capstone.danjinae.vehicle.repository.VehicleRepository;
import com.capstone.danjinae.vehicle.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.Jwts;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.function.Function;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApartService apartService;

    // 입주민 등록
    @PostMapping("/add")
    public Boolean inputUser(@RequestBody UserRequest user) {
        try {
            User toadd;
            User mgr = userService.getUser(user.getMgrId());
            toadd = User.builder().aptId(mgr.getAptId()).name(user.getName()).address(user.getAddress())
                    .birth(new Timestamp(user.getBirth().getTime())).phone(user.getPhone()).build();
            toadd.Resident();

            User addedUser = userService.writeUser(toadd);

            if (user.getCarnumber() != null && user.getCarphone() != null) {
                Vehicle vtoadd = Vehicle.builder().number(user.getCarnumber()).phone(user.getCarphone())
                        .userId(addedUser.getId()).build();
                vehicleService.writeResidnet(vtoadd);
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @GetMapping("/aptchoice")
    public Page<AptListResponse> chooseApt(
            @PageableDefault(page = 0, size = 10, sort = "aptId", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(value = "address", required = false) String address) {

        Page<AptListResponse> dtolist;
        try {
            if (address == null) {
                address = "";
            }
            var list = apartService.searchAddress(address, pageable);
            dtolist = list.map(new Function<Apartment, AptListResponse>() {

                @Override
                public AptListResponse apply(Apartment entity) {
                    AptListResponse dto = new AptListResponse();
                    dto.setAptId(entity.getAptId());
                    dto.setAddress(entity.getAddress());
                    dto.setName(entity.getName());
                    return dto;
                }
            });
        } catch (Exception e) {
            return null;
        }

        return dtolist;
    }

    // 입주민 인증
    @PostMapping("/authorization")
    public Boolean authorization(@RequestBody AuthoUserRequest request, HttpServletResponse response) {
        try {
            User newUser = loginService.CheckResident(request);
            if (newUser == null)
                return false;
            else
                return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/signup")
    public Boolean SignUp(@RequestBody LoginUserRequest request) {
        try {
            return loginService.SignUpUser(request.getPhone(), request.getPassword());
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/login")
    public Boolean Login(@RequestBody LoginUserRequest request, HttpServletResponse response) {
        try {
            User user = loginService.loginUser(request.getPhone(), request.getPassword());
            String token = jwtService.generateToken(request.getPhone());
            String refreshJwt = jwtService.generateRefreshToken(user);

            response.setHeader(jwtService.ACCESS_TOKEN_NAME, token);
            response.setHeader(jwtService.REFRESH_TOKEN_NAME, refreshJwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
