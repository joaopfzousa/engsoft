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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int ects;

    private int year;

    private int semester;

    @ManyToOne
    private Degree degree;
    /**
     * @element-type Student
     */
/**
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student s) {
        this.students.add(s);
        s.addCourse(this);
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
public class Course extends BaseModel{

    private String name;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Degree degree;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students=new HashSet<>();

    private int ects;
    private int semester;
    private int year;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, int ects) {
        this(name);
        this.ects = ects;
    }

    public Course(String name, int ects, int year) {
        this(name,ects);
        this.year= year;
    }

    public Course(String name, int ects, int year,int semester) {
        this(name,ects,year);
        this.semester = semester;
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.addCourse(this);
    }
}
