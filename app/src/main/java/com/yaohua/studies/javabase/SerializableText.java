package com.yaohua.studies.javabase;

import android.util.Log;

import com.yaohua.structure.ArrayListSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SerializableText {
    private static final String PATH = "./super.bin";

    public static void main(String[] args) throws Exception {
        Integer[] integers = {1, 3, -2, -10};
        System.out.println(Arrays.toString(integers));
        ArrayListSort.select_sort(integers);
        System.out.println(Arrays.toString(integers));
        String[] strings = {"11", "3", "2", "10"};
        System.out.println(Arrays.toString(strings));
        ArrayListSort.bubble_sort(strings);
        System.out.println(Arrays.toString(strings));
        Arrays.asList("1","2","3");
    }

    private static void serializeAnimal() throws Exception {
        BlackAnimal black = new BlackAnimal("black", "我是黑猫");
        System.out.println("序列化前："+black.toString());
        System.out.println("=================开始序列化================");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
        oos.writeObject(black);
        oos.flush();
        oos.close();
    }

    private static void deserializeAnimal() throws Exception {
        System.out.println("=================开始反序列化================");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH));
        BlackAnimal black = (BlackAnimal) ois.readObject();
        ois.close();
        System.out.println(black);
    }

}
