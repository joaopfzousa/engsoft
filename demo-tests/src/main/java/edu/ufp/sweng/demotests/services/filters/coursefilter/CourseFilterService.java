package edu.ufp.sweng.demotests.services.filters.coursefilter;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.services.filters.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourseFilterService {

    public Set<Course> filterCourses(Set<Course> courses, FilterObject filterObject) {
        FilterI<Course> courseECTSFilter = new CourseEctsFilter(filterObject.getEcts());
        FilterI<Course> courseSemesterFilter = new CourseSemesterFilter(filterObject.getSemester());

        FilterI<Course> ectsAndSemesterFilter = new AndFilter<>(courseECTSFilter, courseSemesterFilter);

        FilterI<Course> courseYearFilter = new CourseYearFilter(filterObject.getYear());
        FilterI<Course> ectsAndSemesterAndYearFilter = new AndFilter<>(ectsAndSemesterFilter, courseYearFilter);

        return ectsAndSemesterAndYearFilter.filter(courses);
    }
}
