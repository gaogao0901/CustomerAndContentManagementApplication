package com.example.its.domain.auth;

import lombok.Data;

@Data
public class User {

    private String username;
    private String password;
    private Authority authority;

    public enum Authority {
        ADMIN,
        USER,
        DEFAULT_VALUE
    }

    // コンストラクタを修正
    public User(String username, String password, Authority authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    // デフォルトコンストラクタを追加
    public User() {
    }
}