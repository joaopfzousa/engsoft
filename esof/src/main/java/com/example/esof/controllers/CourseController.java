package com.example.esof.controllers;

import com.example.esof.repositories.CourseRepo;

import com.example.esof.models.*;

import com.example.esof.repositories.DegreeRepoI;
import com.oracle.javafx.jmx.json.JSONDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private DegreeRepoI degreeRepoI;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<Course>getAllCourse(){
     return courseRepo.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Course getById(@PathVariable("id") Long id){
        return courseRepo.findById(id).get();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Course getById(@PathVariable("name") String name){
        return courseRepo.findByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Course createCourse(@RequestBody Course course, @PathVariable("nameDegree") String nameDegree){
        //degree.addCourse = degreeRepoI.findByName(name);
        //degree.addCourse(course);
        //degreeRepoI.save(degree);
        return course;
    }
}
