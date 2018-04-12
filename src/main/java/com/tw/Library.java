package com.tw;

import java.util.List;
import java.util.Scanner;
import java.util.regex.*;


public class Library {
    private List<Student> students;
    public boolean someLibraryMethod() {
        mainView();
        return true;
    }

    public void mainView(){
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
        System.out.println("请输入你的选择（1～3）：");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        System.out.println(input);
        switch (keyboard.toString()){
            case "1":
                addStudent();
            case "2":
                getGrades();
            case "3":
                System.exit(0);
        }
    }

    public void addStudent(){
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        String content = keyboard.toString();
        String pattern = "(\\W+,\\d+)(\\,\\W+:(\\d+)(.\\d+)?){4}";
        boolean isMatch = Pattern.matches(pattern, content);
        if (isMatch){
            String[] student_info =  content.split(",");
        }else{
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
        }

    }

    public void getGrades(){
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        Scanner keyboard = new Scanner(System.in);
    }

    public Student getStudnet(String[] student_info){
        String name = student_info[0];
        int id = Integer.parseInt(student_info[1]);
        String[] mathStr = student_info[2].split(":");
        String[] chineseStr = student_info[3].split(":");
        String[] englishStr = student_info[4].split(":");
        String[] programStr = student_info[5].split(":");
        Student newStudent = new Student(name,id,mathStr[1],chineseStr[1],englishStr[1],programStr[1]);
        return newStudent;

    }
}

