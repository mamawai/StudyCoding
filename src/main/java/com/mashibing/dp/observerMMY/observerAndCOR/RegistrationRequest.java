package com.mashibing.dp.observerMMY.observerAndCOR;

/**
 * 用户注册请求
 */
public class RegistrationRequest {
    private String username;
    private String email;
    public RegistrationRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
}
