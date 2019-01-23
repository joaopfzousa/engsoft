package edu.ufp.sweng.demotests.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Degree extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Course> courses=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Student> students=new HashSet<>();

    public Degree() {
    }

    public Degree(String name) {
        this.name = name;
    }


    public void addCourse(Course course){
        courses.add(course);
        course.setDegree(this);
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.setDegree(this);
    }

}
