package com.yaohua.studies.javabase;

public class FooException {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test(){
        try {
            tryBlock = 0;
        }catch (Exception e){
            catchBlock = 1;
        }finally {
            finallyBlock =2;
        }
        methodExit =3;
    }
}
