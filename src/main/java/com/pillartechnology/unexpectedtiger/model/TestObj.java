package com.pillartechnology.unexpectedtiger.model;

import org.springframework.stereotype.Component;

/**
 * Created by erinbergman on 2/8/17.
 */

public class TestObj {

    private String hello;
    private String bye;

    public TestObj(String hello, String bye) {
        this.hello = hello;
        this.bye = bye;
    }



    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getBye() {
        return bye;
    }

    public void setBye(String bye) {
        this.bye = bye;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "hello has a value of '" + hello + '\'' +
                ", bye has a value of '" + bye + '\'' +
                '}';
    }
}
