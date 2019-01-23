package com.example.esof.filters;

import com.example.esof.models.Course;

//import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseEctsFilter implements CourseFilter{
    private int ectsToFilter;

    public CourseEctsFilter(int ectsToFilter) {
        this.ectsToFilter = ectsToFilter;
    }

    @Override
    public Set<Course> filter(Set<Course> courses) {
        if(ectsToFilter==0) return courses;
        return courses.stream()
                .filter(course -> course.getEcts()==this.ectsToFilter)
                .collect(Collectors.toSet());
    }
}
