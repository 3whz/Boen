package com.boen.domain;

public class Gym {
    private Integer maximum;

    @Override
    public String toString() {
        return "Gym{" +
                "maximum=" + maximum +
                '}';
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
}
