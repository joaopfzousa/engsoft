package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.services.filters.FilterObject;

import java.util.Optional;
import java.util.Set;

public interface CourseServiceI {
    Set<Course> getSetCourse();

    Set<Course> getFilteredCourses(FilterObject filterObject);

    Set<Course> getAllCourses();

    Optional<Course> getCourseByName(String name);

    Course save(Course course);

    Optional<Course> getById(Long id);

    Optional<Course> saveCourse(Course course, String degreeName);
}
