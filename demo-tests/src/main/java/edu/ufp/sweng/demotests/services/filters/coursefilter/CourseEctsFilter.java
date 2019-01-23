package edu.ufp.sweng.demotests.services.filters.coursefilter;

import edu.ufp.sweng.demotests.models.Course;

import java.util.Set;
import java.util.stream.Collectors;

//import java.util.HashSet;

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
