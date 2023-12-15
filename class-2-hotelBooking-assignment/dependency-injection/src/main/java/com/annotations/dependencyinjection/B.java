package com.annotations.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class B {

    private  String color;

    public B() {
        color = "Red";
        System.out.println("Testing constructor for class B");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
