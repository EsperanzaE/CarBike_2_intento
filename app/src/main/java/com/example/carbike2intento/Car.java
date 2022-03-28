package com.example.carbike2intento;

public class Car {
    private String name;
    private int image;

    public Car() {
    }

    public Car(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
