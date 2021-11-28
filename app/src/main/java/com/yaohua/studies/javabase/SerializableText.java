package com.yaohua.studies.javabase;

import android.content.Intent;
import android.util.Log;

import com.yaohua.structure.ArrayListSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
        //用最小的时间复杂度和空间复杂度处理一个非严格有序int[]数组实现去重、如
        //1、1、1、2、3、3、4、4、5、6、6
        int [] useCase1 = {1,1,1,2,3,3,4,4,5,6,6};
        fixSameElement(useCase1,useCase1.length,new ArrayList<>());
        for (int j : useCase1) {
            System.out.print(j+" ");
        }
        System.out.println();

        //selection
        Integer[] useCase2 = {1,1,2,3,4,-1,-2,-9};
        selection(useCase2);
        for(int j : useCase2){
            System.out.print(j+" ");
        }
    }

    private static void fixSameElement(int[] useCase1, int length, ArrayList<Integer> ans) {
        if(useCase1 ==null || useCase1.length==1) return;
        int slowPointer;
        int fastPointer;
        slowPointer = 0;
        for(fastPointer = 1; fastPointer<length; fastPointer++){
            if(useCase1[slowPointer]!=useCase1[fastPointer]){
                slowPointer++;
                useCase1[slowPointer] = useCase1[fastPointer];
            }
        }
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

    public static <T extends Comparable<T>> void selection (T[] list){
        T currentElement;
        int currentIndex;
        for(int i = 0; i< list.length-1;++i){
            currentIndex = i;
            currentElement = list[i];
            for (int j = i+1; j< list.length;++j){
                if(currentElement.compareTo(list[j])>0){
                    currentIndex = j;
                    currentElement = list[j];
                }
            }
            if(i!=currentIndex){
                list[currentIndex] = list[i];
                list[i] = currentElement;
            }
        }
    }

}
