package edu.ufp.sweng.demotests.controllers;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.services.CourseServiceI;
import edu.ufp.sweng.demotests.services.filters.FilterObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseServiceI courseServiceI;

    private Logger logger= LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseServiceI courseServiceI) {
        this.courseServiceI = courseServiceI;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Course> getAllCourse(@ModelAttribute FilterObject filterObject){
        logger.info(filterObject.toString());
        return courseServiceI.getFilteredCourses(filterObject);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Course getById(@PathVariable("id") Long id){
        Optional<Course> courseDTOOptional= courseServiceI.getById(id);
        return courseDTOOptional.orElse(null);
    }

    @RequestMapping(value="/name/{name}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> getByName(@PathVariable("name") String name){
        Optional<Course> courseDTOOptional=courseServiceI.getCourseByName(name);
        if(courseDTOOptional.isPresent()){
            return ResponseEntity.ok(courseDTOOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{degreeName}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> saveCourse(@RequestBody Course course, @PathVariable("degreeName") String degreeName){
        logger.info(course.toString()+" "+degreeName);
        Optional<Course> courseOptional= courseServiceI.saveCourse(course,degreeName);
        if(courseOptional.isPresent()){
            return ResponseEntity.ok(courseOptional.get());
        }
        return ResponseEntity.notFound().build();

    }
}
