package com.testeandroidv2.bank.loginScreen;

public class LoginModel {
    String user;
    String password;
    int status;
}

class LoginViewModel {
    int status;
}

class LoginRequest {
    String user;
    String password;
}

class LoginResponse {
    int status;
}