package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends CrudRepository<Student,Long> {
    Optional<Student> findByStudentNumber(String studentNumber);
}
