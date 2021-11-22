package com.yaohua.studies.javabase;

import android.util.Log;

import com.yaohua.structure.ArrayListSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;

public class SerializableText {
    private static final String PATH = "./super.bin";

    public static void main(String[] args) {
        int dTestArray[] = {1,8,6,9,10,15,12,20};
        ArrayList<Integer> res = new ArrayList<>();
        findThePivotElement(dTestArray,dTestArray.length,res);
        System.out.println(res);
    }

    private static void findThePivotElement(int[] data, int len, ArrayList<Integer> res) {
        int[] tempArray = new int[len];
        int r_min = data[len-1];
        for(int i = len-1;i>=0;--i){
            if(data[i]<r_min){
                r_min = data[i];
            }
            tempArray[i] = r_min;
        }
        int l_max = data[0];
        for (int i = 0;i<len-1;++i){
            if(data[i]>l_max){
                l_max = data[i];
                if(data[i]<tempArray[i+1]){
                    res.add(data[i]);
                }
            }
        }
    }

}
