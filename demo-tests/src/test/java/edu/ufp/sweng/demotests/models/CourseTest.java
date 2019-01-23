package edu.ufp.sweng.demotests.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testAddStudent(){
        Degree degree1=new Degree("degree1");
        Degree degree2=new Degree("degree2");

        Course course1=new Course();
        degree1.addCourse(course1);

        Student s1=new Student("12345",degree1);
        Student s2=new Student("23456",degree2);


        assertEquals(0,course1.getStudents().size());
        course1.addStudent(s1);
        assertEquals(1,course1.getStudents().size());
        course1.addStudent(s2);
        assertEquals(1,course1.getStudents().size());

    }
}