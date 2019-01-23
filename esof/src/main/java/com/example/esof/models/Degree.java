/**

package com.example.esof.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * @element-type Course
     */
/**
    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
    /**
     * @element-type Student
     */
/**
    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public void addCourse(Course c) {
        this.courses.add(c);
        c.setDegree(this);
    }

    public void addStudent(Student s){
        this.students.add(s);
        s.setDegree(this);
    }
}
**/

package com.example.esof.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Degree extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Course> courses=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Student> students=new HashSet<>();

    public Degree(String name) {
        this.name = name;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.setDegree(this);
    }
}
