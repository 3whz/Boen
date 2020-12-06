package com.boen.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer sex;
    private String email;
    private String img;
    private Integer coach;
    private Integer state;
    //映射关系
    private List<GymClass> gymClass;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", coach=" + coach +
                ", state=" + state +
                ", gymClass=" + gymClass +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getCoach() {
        return coach;
    }

    public void setCoach(Integer coach) {
        this.coach = coach;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<GymClass> getGymClass() {
        return gymClass;
    }

    public void setGymClass(List<GymClass> gymClass) {
        this.gymClass = gymClass;
    }
}
