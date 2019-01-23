package edu.ufp.sweng.demotests.services.filters.coursefilter;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.services.filters.FilterI;

import java.util.Set;

public interface CourseFilter extends FilterI<Course> {
    Set<Course> filter(Set<Course> entities);
}
