package com.example.esof.repositories;

import com.example.esof.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long>{
    Course findByName(String name);
}
