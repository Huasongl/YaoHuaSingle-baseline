package com.yaohua.studies.javabase;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class Animal {
    private String color;

    public Animal(){

    }

    public Animal(String color){
        this.color = color;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                '}';
    }
}
