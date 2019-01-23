package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long> {
    Optional<Course> findByName(String name);
}
