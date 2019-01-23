package edu.ufp.sweng.demotests.repositories;


import edu.ufp.sweng.demotests.models.Course;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CourseRepoUnitTest {
    Course course=new Course("course1");

    @Mock
    private CourseRepo courseRepo;

    @Before
    public void setup(){
        when(courseRepo.findByName("course1"))
                .thenReturn(Optional.of(course));
    }

    @Test
    public void findByName(){
        assertEquals(course,courseRepo.findByName("course1").get());
    }
}
