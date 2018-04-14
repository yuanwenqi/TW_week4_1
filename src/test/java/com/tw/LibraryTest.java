package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));

    }

    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }
//
    @Test
    public void testMainView() throws Exception {
          Library l = new Library();
          ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
          System.setIn(in);
          l.mainView();
          assertTrue(outContent.toString().endsWith("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n"));
          ByteArrayInputStream in2 = new ByteArrayInputStream("2".getBytes());
          System.setIn(in2);
          l.mainView();
          assertTrue(outContent.toString().endsWith("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n"));
    }

    @Test
    public void testAddStudent() throws Exception{
        Library library = new Library();
        ByteArrayInputStream in = new ByteArrayInputStream("姓名,12,数学:80,语文:89,英语:94,编程:90".getBytes());
        System.setIn(in);
        library.addStudent();
        assertTrue(outContent.toString().endsWith("学生姓名的成绩被添加\n"));
        ByteArrayInputStream in2 = new ByteArrayInputStream("姓名,12,数学:80,语文:89,英语:94".getBytes());
        System.setIn(in2);
        library.addStudent();
        assertTrue(outContent.toString().endsWith("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n"));

    }

    @Test
    public void testGetS() throws  Exception{
        Library library = new Library();
        ByteArrayInputStream in = new ByteArrayInputStream("姓名,12,数学:80,语文:89,英语:94,编程:90".getBytes());
        System.setIn(in);
        library.addStudent();
        in= new ByteArrayInputStream("12".getBytes());
        System.setIn(in);
        library.getGrades();
        assertTrue(outContent.toString().endsWith("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "姓名|80.0|89.0|94.0|90.0|88.25|353.0\n" +
                "========================\n" +
                "全班总分平均数353.0\n" +
                "全班总分中位数353.0\n"));
        in = new ByteArrayInputStream("姓x名,13,数学:80,语文:89,英语:94,编程:90".getBytes());
        System.setIn(in);
        library.addStudent();
        in= new ByteArrayInputStream("12,13".getBytes());
        System.setIn(in);
        library.getGrades();
        assertTrue(outContent.toString().endsWith("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "姓名|80.0|89.0|94.0|90.0|88.25|353.0\n" +
                "姓x名|80.0|89.0|94.0|90.0|88.25|353.0\n" +
                "========================\n" +
                "全班总分平均数353.0\n" +
                "全班总分中位数353.0\n"));

    }



}
