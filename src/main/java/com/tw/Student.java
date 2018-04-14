package com.tw;

public  class Student extends Object{
    private String name;
    private String id;
    private float math;
    private float chinese;
    private float english;
    private float programming;


    public Student(String name, String id, String math, String chinese, String english, String programming) {
        this.name = name;
        this.id = id;
        this.math = Float.parseFloat(math);
        this.chinese = Float.parseFloat(chinese);
        this.english = Float.parseFloat(english);
        this.programming = Float.parseFloat(programming);
    }

    public  String getId(){
        return  this.id;
    }
    public float getSum(){
        return math+chinese+english+programming;
    }

    public float getAve(){
        return getSum()/4;
    }

    public String getName() {
        return name;
    }

    public float getMath(){
        return this.math;
    }

    public  float getChinese(){
        return  this.chinese;
    }

    public  float getEnglish(){
        return  this.english;
    }
    public  float getProgramming(){
        return  this.programming;
    }

    public boolean equals(Object object){
        if (object instanceof Student){
            Student s = (Student)object;
            if (this.getName() == s.getName() & this.getId()== s.getId() & this.getEnglish() == s.getEnglish()
                    & this.getMath() == s.getMath() & this.getChinese() == s.getChinese()
                    & this.getProgramming() == s.getProgramming()){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
