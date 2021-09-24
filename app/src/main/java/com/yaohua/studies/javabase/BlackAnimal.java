package com.yaohua.studies.javabase;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class BlackAnimal extends Animal implements Serializable {
    private String name;

    public BlackAnimal(){
        super();
    }

    public BlackAnimal(String color, String name){
        super(color);
        this.name = name;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return  "BlackCat{" +
                "name='" + name + '\'' +super.toString() +'\'' +
                '}';
    }
}
