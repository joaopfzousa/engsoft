package com.example.esof.filters;

import com.example.esof.models.Course;

import java.util.Set;

public class AndFilter implements CourseFilter {
    private CourseFilter  filter;
    private CourseFilter  otherFilter;

    public AndFilter(CourseFilter  filter, CourseFilter  otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }


    @Override
    public Set<Course> filter(Set<Course> courses) {
        Set<Course> firstFilterCourses=this.filter.filter(courses);
        return this.otherFilter.filter(firstFilterCourses);
    }
}
