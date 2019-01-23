package com.example.esof.filters;

import com.example.esof.models.Course;

//import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseSemesterFilter implements CourseFilter {

    private int semesterToFilter;

    public CourseSemesterFilter(int semesterToFilter) {
        this.semesterToFilter = semesterToFilter;
    }

    @Override
    public Set<Course> filter(Set<Course> courses) {
        if(semesterToFilter==0)return courses;
//        Set<Course> courseSet=new HashSet<>();

//        for(Course course:courses){
//            if(course.getSemester()==this.semesterToFilter){
//                courseSet.add(course);
//            }
//        }
        return courses.stream()
                .filter(course -> course.getSemester()==this.semesterToFilter)
                .collect(Collectors.toSet());
    }
}
