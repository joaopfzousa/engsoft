package edu.ufp.sweng.demotests.services.filters.coursefilter;

import edu.ufp.sweng.demotests.models.Course;

import java.util.Set;
import java.util.stream.Collectors;

//import java.util.HashSet;

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
