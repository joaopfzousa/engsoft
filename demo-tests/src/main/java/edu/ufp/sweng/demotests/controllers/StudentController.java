package edu.ufp.sweng.demotests.controllers;


import edu.ufp.sweng.demotests.models.Student;
import edu.ufp.sweng.demotests.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Student>> getAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.findById(id).get());
    }

}
