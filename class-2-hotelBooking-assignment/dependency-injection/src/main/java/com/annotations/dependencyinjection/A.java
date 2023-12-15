package com.annotations.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class A {

    @Autowired
    B objB;

    public A() {
        System.out.println("constructor of A");
    }

    @GetMapping("FetchB")
    public B getB()
    {
        return objB;
    }


}
