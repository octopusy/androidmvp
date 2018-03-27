package com.module.mvp.model;

/**
 * @project：androidmvp
 * @author：- octopus on 2018/3/27 16:42
 * @email：zhanghuan@xinguodu.com
 */
public class PersonModel {

    private String username;
    private String password;

    public PersonModel(String userName,String password) {
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
