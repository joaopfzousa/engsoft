package com.example.esof.filters;

import com.example.esof.models.Course;

import java.util.Set;

public interface CourseFilter {
    Set<Course> filter(Set<Course> entities);
}
