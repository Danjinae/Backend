importScripts('https://www.gstatic.com/firebasejs/5.9.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/5.9.2/firebase-messaging.js');

let firebaseConfig = {
    "type": "service_account",
    "project_id": "danjinae-8b6ca",
    "private_key_id": "f00e5570f832a54617f12fd41d86732227620ca7",
    "private_key": "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDLyUSMwMXIu6bq\n5sUGdaWJAaa0+WoT2ViTKclgCKTlKbJTOea1g7bqG007OB3dgt4RGRaMwkuXXMXw\ngfhz/BEx2DCAnWgj4lzN++4nfDumXNMTUWTarA6/5NINRfOxDSbO5St7rihV04Zr\n6krh9YRbSAwTz3qs69HSSIw0FhTcqlKf23NnMdfCtI1x9W+ILi2wFeTenrShZeqP\nOqS/YvVaDsV0iIHQ7598NguhVT8nSYl3KYpAn0cYeQ+tM6D1fC4SVxOoCIhOtyxs\nbb2TObB6P6VV3RsVx66VJ2NfcE5Xdg8tXoTe7GWnmTN7a+TRxYT9VTjj5G2NkUn2\njHDi/I0xAgMBAAECggEAL/3kQOmdKprWwnc6az0FkPBsnC4oxyfmbjHnFNC0VKuv\nLV5zcMfmKdfoJkwe7G3HcmtgHiIbvze//dX99wKj4gMx2Pg48Ep85J2yBmaBfbpa\nkzAV+lGO3645sZqJu2aHfy4FQYlQQnYgMAXrQK+bTgv3nCq+jz6yGT2wlwukOhsO\nqfk26r1mZ105tvjo5KjYslm5bUzhZsLKpIXh35cwvmvfBV0hiP/clJEHviPDRZ9I\nNb25qg6QQBLRI4zXI7uXCy22NS9GhtH/6Hh2Jh9UhK0/Y3ympGhl5jwaqDMcoRzz\n87EoLIucbj70Hpi0h52ciDiROl8xtjAblO6nKe2CiQKBgQD0dbSg8ifOYSqoSNDh\nnW5/nZM9xxPh/1/nKjf13u+t0y9X1Nhf3hiC16Ryw2DnS32wlStAg5zauwgSM4iY\nkLsSoGDQ9LeDazdSUsgOSnn1pqXx/OfqVFoitphDoiBEt5JnatO06bWHAyRz2y4U\nGQF6Xjve32WuUIqMxFopaweMKwKBgQDVaAWzPd3MIUmnQXLYmQN20Yy1PXRaSQyG\ncPo3oHDipxL0uBFqZbrr3uTsgt5CZ8//JeaLsN07DwBhDlok8kspmPYjVix/9ffl\nEqQ2/MHPIO6GL6f12uNOp1u5MfRdjMFNlWhp403gPLMTVIaczMRe6wxS1iULYcCd\nMxaT5AZyEwKBgQCTGbETmCOz4GxWz1pCKQWw7RUI+55PQ+hlpdX+saPwKUA3zfBV\n38NIGJLwK/lHtPlxJJHeRFRCmoEE0tXDWHP5hWA83MUA46dqdj3Du7UfyKPataCo\nNRH4CYAeUpSwRPZoHLRADNIa6B0rShy0I0fsZoAIYM1C01xL0GuguLLV+QKBgBwQ\nA7/gQMxZDEBsQNfutx/mymQC4swEkxsSvDSYan/DjKCVm+Sr3/qoYt4fD28YC6f3\nqetwpIbhoCEjLANzwSKFNMjMyilBhQmge+unLS05nWQT3DheQknThCJESWgL3FeB\ncCuMcm8sTDgcg18XJjN9IS+7bT+j6RpC35MvBxH1AoGBANe4YzBTtHMBi6Ffw0dR\nmkInB6v6a6YAvDl1gALTLVgFWun4IoT8/l3XtmXpXhA0VZYHEJxpYx9E6d6KabJV\n3+qUAAIIo+GR7/CaUkoul3Gh5EmBSv8lRMcg0kzbpiZ31pNkAlIt5Mzz8UvTJVD7\nAUuzsZ/JyEN4Y+gqsuX8cLau\n-----END PRIVATE KEY-----\n",
    "client_email": "firebase-adminsdk-l0b9i@danjinae-8b6ca.iam.gserviceaccount.com",
    "client_id": "101371425601147551198",
    "auth_uri": "https://accounts.google.com/o/oauth2/auth",
    "token_uri": "https://oauth2.googleapis.com/token",
    "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
    "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-l0b9i%40danjinae-8b6ca.iam.gserviceaccount.com"
};

firebase.initializeApp(firebaseConfig);
const messaging = firebase.messaging();