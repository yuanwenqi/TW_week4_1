package com.tw;

import java.util.*;
import java.util.regex.*;


public class Library {
    private HashMap<String,Student> students = new HashMap<>();
    public boolean someLibraryMethod() {
        return true;
    }

    public String Test1(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        return input;
    }

    public void mainView(){
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
        System.out.println("请输入你的选择（1～3）:");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        switch (input){
            case "1":
                System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                addStudent();
                break;
            case "2":
                System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                getGrades();
                break;
            case "3":
                System.exit(0);
                break;
        }

    }


    public void addStudent(){
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String pattern = "(\\W+\\,\\d+)(\\,\\W+:(\\d+)(\\.\\d+)?){4}";
        boolean isMatch = Pattern.matches(pattern, input);
        if (isMatch){
            Student oneStudent = getStudnet(input);
            students.put(oneStudent.getId(),oneStudent);
            System.out.println("学生"+oneStudent.getName()+"的成绩被添加");
//            mainView();
        }else{
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）:");
            addStudent();
        }

    }

    public void getGrades(){
        String pattern = "\\d+(\\,\\d+)*";
        Scanner keyboard = new Scanner(System.in);
        String content = keyboard.nextLine();
        boolean isMatch = Pattern.matches(pattern, content);
        if (!isMatch){
            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            getGrades();
        }else{
            String[] keys = content.split(",");
            printGrades(keys);
        }


    }

    public void printGrades(String[] keys){
        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================");
        for(String i:keys){
            if (students.containsKey(i)){
                Student s = students.get(i);
                System.out.println(s.getName()+"|"+s.getMath()+"|"+s.getChinese()+"|"+s.getEnglish()+"|"+s.getProgramming()
                        +"|"+s.getAve()+"|"+s.getSum());
            }
        }
        System.out.println("========================");
        List<Float> grads = new ArrayList<>();
        float Sum = 0.0f;
        for(String i:students.keySet()){
            Student s = students.get(i);
            grads.add(s.getSum());
            Sum += s.getSum();
        }
        float aveSum = Sum/students.size();

        System.out.println("全班总分平均数"+aveSum);
        System.out.println("全班总分中位数"+getMedian(grads));
    }

    public float getMedian(List<Float> list){
        Collections.sort(list);
        if (list.size()%2 ==0){
            return (list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        }else {
            return list.get(list.size()/2);
        }
    }
    public Student getStudnet(String input){
        String[] student_info =  input.split(",");
        String name = student_info[0];
        String id = student_info[1];
        String[] mathStr = student_info[2].split(":");
        String[] chineseStr = student_info[3].split(":");
        String[] englishStr = student_info[4].split(":");
        String[] programStr = student_info[5].split(":");
        Student newStudent = new Student(name,id,mathStr[1],chineseStr[1],englishStr[1],programStr[1]);
        return newStudent;

    }


}

