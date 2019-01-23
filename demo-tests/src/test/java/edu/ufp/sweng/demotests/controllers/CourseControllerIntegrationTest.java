package edu.ufp.sweng.demotests.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.sweng.demotests.DemoTestsApplication;
import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.services.CourseServiceI;
import edu.ufp.sweng.demotests.services.filters.FilterObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoTestsApplication.class)
@AutoConfigureMockMvc
@Transactional
public class CourseControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CourseServiceI courseService;


    @Autowired
    ObjectMapper mapper;

    @Before
    public void setUp(){

        Course course=new Course("course1");
        courseService.save(course);
    }

    @Test
    public void getAllCourse() throws Exception {
        Iterable<Course> courses=courseService.getFilteredCourses(new FilterObject());
        mvc.perform(get("/course").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(courses)))
                .andReturn();
    }

    @Test
    public void getById() throws Exception {
        Course course=courseService.getById(1l).get();
        mvc.perform(get("/course/1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(course.getName()))
                .andReturn();

        mvc.perform(get("/course/error").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getByName() throws Exception {
        Course course=courseService.getCourseByName("course1").get();
        mvc.perform(get("/course/name/course1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(course.getName()))
                .andReturn();

        mvc.perform(get("/course/name/error").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void saveCourse() {
    }
}