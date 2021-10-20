package com.yaohua.structure;


import java.util.List;
import java.util.jar.JarEntry;

public class ArrayListSort {
    public static int TYPE_SORT_BUBBLE = 1;
    public static int TYPE_SORT_SELECT = 2;
    public static int TYPE_SORT_INS = 3;
    public static int TYPE_SORT_SIMPLE = 0;
    public static int DEFAULT = TYPE_SORT_SIMPLE;
    public static int TYPE_SORT_LEVEL = DEFAULT;
    public static int TYPE_SORT_MID = 1;
    public static int TYPE_SORT_HIGH = 2;

    public ArrayListSort(){

    }

    public static <T extends Comparable<T>> void bubble_sort(T[] list){
        T tempElement;
        boolean flag = true;
        for(int i =0;i<list.length || flag;++i){
            tempElement = list[i];
            flag =false;
            for (int j =0;j< list.length -i-1;++j){
                if(list[j].compareTo(list[j+1])>0){
                    T temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                    flag = true;
                }
            }
        }
    }

    public <E extends Comparable<E>> void bubble_sort_1(E[] list){
        E tempElement;
        boolean flag =true;
        for(int i = 0;i< list.length||flag;++i){
            flag = false;
            tempElement = list[i];
            for (int j = 0 ;j<list.length - i -1;++j){
                if(list[j].compareTo(list[j+1])>0){
                    E temp = list[j+1];
                    list[j+1] = list[j];
                    list[j]  = temp;
                    flag = true;
                }
            }
        }
    }

    public <E extends Comparable<E>> void insert_sort(E[] list){
        E currentElement;
        int j;
        for(int i = 1; i< list.length; ++i){
            currentElement = list[i];
            for ( j = i-1; j>= 0; --j){
                if(list[j].compareTo(currentElement)>0){
                    list[j+1] = list[j];
                }
            }
            list[j+1] = currentElement;
        }
    }

    public <E extends Comparable<E>> void insert_sort_1(E[] list){
        E currentElement;
        int j;
        for(int i =1;i< list.length;++i){
            currentElement = list[i];
            for ( j = i-1;j>=0;--j){
                if(list[j].compareTo(currentElement)>0){
                    list[j+1] = list[j];
                }
            }
            list[j+1] = currentElement;
        }
    }

    public static <E extends Comparable<E>> void select_sort(E[] list){
        E currentElement;
        int index;
        for(int i = 0; i<list.length-1; ++i){
            currentElement = list[i];
            index = i;
            for(int j = i+1; j< list.length; ++j){
                if(currentElement.compareTo(list[j])>0){
                    currentElement = list[j];
                    index = j;
                }
            }
            if(index!= i){
                list[index] = list[i];
                list[i] =currentElement;
            }
        }
    }

}
