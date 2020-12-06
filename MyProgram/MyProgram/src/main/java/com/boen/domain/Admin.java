package com.boen.domain;

public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String email;
    private String img;
    private Integer jurisdiction;
    private Integer state;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", jurisdiction=" + jurisdiction +
                ", state=" + state +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
