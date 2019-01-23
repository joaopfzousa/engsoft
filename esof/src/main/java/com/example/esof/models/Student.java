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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentNumber;

    /**
     * @element-type Course
     */
/**
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    private Degree degree;

    public void addCourse(Course c) {
        this.courses.add(c);
    }

}
 **/

package com.example.esof.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends BaseModel {

    private String studentNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Course> courses =new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private Degree degree;

    public Student(String studentNumber,Degree degree) {
        this.studentNumber = studentNumber;
        this.degree=degree;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

}