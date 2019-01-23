package edu.ufp.sweng.demotests.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.sweng.demotests.DemoTestsApplication;
import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.services.CourseService;
import edu.ufp.sweng.demotests.services.CourseServiceI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private CourseServiceI createClientServiceMock;

    @InjectMocks
    private CourseController courseController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    public void testCreateClientSuccessfully() throws Exception {

        Course course = new Course("course1");
        Course expectedCourse = new Course("course1");
        expectedCourse.setDegree(new Degree("degree1"));
        given(createClientServiceMock.saveCourse(course, "degree1")).willReturn(Optional.of(expectedCourse));

        mockMvc.perform(post("/course/degree1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(course)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("course1"))
                .andExpect(jsonPath("$.degreeName").value("degree1"));
    }
}
