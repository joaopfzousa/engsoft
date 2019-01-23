package edu.ufp.sweng.demotests.services.filters.coursefilter;

import edu.ufp.sweng.demotests.models.Course;

import java.util.Set;
import java.util.stream.Collectors;

//import java.util.HashSet;

public class CourseYearFilter implements CourseFilter{
    private int yearToFilter;

    public CourseYearFilter(int semesterToFilter) {
        this.yearToFilter = semesterToFilter;
    }

    @Override
    public Set<Course> filter(Set<Course> courses) {
        if(yearToFilter==0)return courses;
//        Set<Course> courseSet=new HashSet<>();
//        for(Course course:courses){
//            if(course.getYear()==this.yearToFilter){
//                courseSet.add(course);
//            }
//        }
        return courses.stream()
                .filter(course -> course.getYear()==this.yearToFilter)
                .collect(Collectors.toSet());
    }
}
