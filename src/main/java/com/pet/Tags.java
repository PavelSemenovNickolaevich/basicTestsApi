package com.pet;

public class Tags {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tags(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tags {" +
                "name='" + name + '\'' +
                '}';
    }
}
