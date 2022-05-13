package com.github.vlsidlyarevich.dto;

public class TokenWithRole {
    private String token;
    private String userRole;

    public TokenWithRole() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
