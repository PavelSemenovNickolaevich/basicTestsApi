package com.pet;

public class PetCategory {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PetCategory{" +
                "name='" + name + '\'' +
                '}';
    }
}
