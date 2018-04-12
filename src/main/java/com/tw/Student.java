package com.tw;

public class Student {
    private final String name;
    private final int id;
    private final float math;
    private final float chinese;
    private final float english;
    private final float programming;


    public Student(String name, int id, String math, String chinese, String english, String programming) {
        this.name = name;
        this.id = id;
        this.math = Float.parseFloat(math);
        this.chinese = Float.parseFloat(chinese);
        this.english = Float.parseFloat(english);
        this.programming = Float.parseFloat(programming);
    }

    public float getSum(){
        return math+chinese+english+programming;
    }

    public float getAve(){
        return getSum()/4;
    }
}
