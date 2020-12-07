package com.boen.domain;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClassClassify {
    private Integer id;
    private String name;
    private Integer state;
    //映射关系
    //有课程查分类代替先留着这个
    private List<GymClass> gymClass;

    @Override
    public String toString() {
        return "ClassClassify{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
