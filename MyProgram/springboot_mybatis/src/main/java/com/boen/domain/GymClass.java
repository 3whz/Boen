package com.boen.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class GymClass {
    private Integer id;
    private String name;
    private String text;
    private String img;
    private String video;
    private Integer difficulty;
    private Integer ci_id;
    private Integer u_id;
    private Integer top;
    private Integer state;
    private ClassClassify classClassify;
    private User user;


    @Override
    public String toString() {
        return "GymClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", img='" + img + '\'' +
                ", video='" + video + '\'' +
                ", difficulty=" + difficulty +
                ", ci_id=" + ci_id +
                ", u_id=" + u_id +
                ", top=" + top +
                ", state=" + state +
                ", classClassify=" + classClassify +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCi_id() {
        return ci_id;
    }

    public void setCi_id(Integer ci_id) {
        this.ci_id = ci_id;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public ClassClassify getClassClassify() {
        return classClassify;
    }

    public void setClassClassify(ClassClassify classClassify) {
        this.classClassify = classClassify;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
