package edu.ufp.sweng.demotests.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@ToString
public class Student extends BaseModel {

    private String studentNumber;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses =new HashSet<>();

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private Degree degree;

    public Student(String studentNumber,Degree degree) {
        this.studentNumber = studentNumber;
        degree.addStudent(this);
    }


    public void addCourse(Course course){
        this.courses.add(course);
    }

    @JsonInclude
    public String getDegreeName() {
        return degree.getName();
    }

}
