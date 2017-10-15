package com.vitalii.prj.service;


public class TestBean {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean() {

    }

    public TestBean(String name) {

        this.name = name;
    }

    private String name;
}
