package com.yaohua.studies.designmethod.ioc;

public abstract class TestCase {
    public void run(){
        if(doTest()){
            System.out.println("Test succeed.");
        }else{
            System.out.println("Text failed.");
        }
    }

    public abstract boolean doTest();
}
