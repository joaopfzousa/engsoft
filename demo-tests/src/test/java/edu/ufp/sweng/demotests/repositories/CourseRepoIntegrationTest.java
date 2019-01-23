package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepoIntegrationTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void crud() {
        Course course=new Course("course1");

        assertEquals(0,courseRepo.count());

        courseRepo.save(course);
        assertEquals(1,courseRepo.count());

        courseRepo.save(course);
        assertEquals(1,courseRepo.count());

    }
}