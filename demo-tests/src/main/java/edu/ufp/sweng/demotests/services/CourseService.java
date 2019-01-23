package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.repositories.CourseRepo;
import edu.ufp.sweng.demotests.repositories.DegreeRepo;
import edu.ufp.sweng.demotests.services.filters.FilterObject;
import edu.ufp.sweng.demotests.services.filters.coursefilter.CourseFilterService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService implements CourseServiceI {


    private CourseFilterService courseFilterService;

    private CourseRepo courseRepo;
    private DegreeRepo degreeRepo;

    public CourseService(CourseFilterService courseFilterService, CourseRepo courseRepo, DegreeRepo degreeRepo) {
        this.courseFilterService = courseFilterService;
        this.courseRepo = courseRepo;
        this.degreeRepo = degreeRepo;
    }

    @Override
    public Set<Course> getSetCourse(){
        Set<Course> courses=new HashSet<>();
        for(Course course:this.courseRepo.findAll()){
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Set<Course> getFilteredCourses(FilterObject filterObject){
        return courseFilterService.filterCourses(getAllCourses(),filterObject);
    }

    @Override
    public Set<Course> getAllCourses(){
        Set<Course> courses=new HashSet<>();
        for(Course course:this.courseRepo.findAll()){
            courses.add(course);
        }
        return Collections.unmodifiableSet(courses);
    }

    @Override
    public Optional<Course> getCourseByName(String name){
        for(Course course:getAllCourses()){
            if (course.getName().equalsIgnoreCase(name)){
                return Optional.of(course);
            }
        }
        return Optional.empty();
    }


    @Override
    public Course save(Course course){
        return this.courseRepo.save(course);
    }


    @Override
    public Optional<Course> getById(Long id) {

        return courseRepo.findById(id);
        /*if(courseOptional.isPresent()){
            return Optional.of(courseOptional.get().getDTO());
        }
        return Optional.empty();*/
    }

    @Override
    public Optional<Course> saveCourse(Course course, String degreeName) {
        Optional<Degree> degreeOptional=this.degreeRepo.findByName(degreeName);
        if(degreeOptional.isPresent()){
            Degree degree=degreeOptional.get();

            degree.addCourse(course);
            degreeRepo.save(degree);
            return courseRepo.findByName(course.getName());
        }
        return Optional.empty();

    }
}
