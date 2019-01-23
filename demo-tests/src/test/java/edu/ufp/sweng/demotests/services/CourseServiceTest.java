package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.repositories.CourseRepo;
import edu.ufp.sweng.demotests.repositories.DegreeRepo;
import edu.ufp.sweng.demotests.services.filters.coursefilter.CourseFilterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @InjectMocks
    private CourseService courseService;

    @Mock
    private CourseRepo courseRepo;

    @Mock
    private CourseFilterService courseFilter;

    @Mock
    private DegreeRepo degreeRepo;

//    Course course=new Course("course1");

    private Set<Course> courses1=new HashSet<>();
    private Set<Course> courses2=new HashSet<>();

    @Before
    public void setUp() {
//        courseService =new CourseService(courseFilter,courseRepo,degreeRepo);
        courses1.add(new Course("course1"));
        courses1.add(new Course("course2"));
        courses1.add(new Course("course3"));

        courses2.add(new Course("course3"));
        when(courseRepo.findAll())
                .thenReturn(courses1);

        when(courseFilter.filterCourses(courses1,null))
                .thenReturn(courses2);

    }

    @Test
    public void crud() {
        assertEquals(3,courseService.getAllCourses().size());
        Mockito.verify(courseRepo, Mockito.times(1)).findAll();
        assertEquals(1, courseService.getFilteredCourses(null).size());
        Mockito.verify(courseRepo,Mockito.times(0)).findByName(Mockito.anyString());
        Mockito.verify(courseRepo,Mockito.times(2)).findAll();
    }
}