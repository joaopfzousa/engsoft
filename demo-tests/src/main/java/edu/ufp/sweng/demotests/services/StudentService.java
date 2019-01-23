package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Student;
import edu.ufp.sweng.demotests.repositories.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Set<Student> findAll(){

        Set<Student> students=new HashSet<>();
        for(Student student:this.studentRepo.findAll()){
            students.add(student);
        }
        return students;

    }

    public Optional<Student> findById(Long id){
        return this.studentRepo.findById(id);
    }

    public Optional<Student> findByName(String studentNumber){
        return this.studentRepo.findByStudentNumber(studentNumber);
    }

    public Optional<Student> save(Student student){
        return Optional.of(this.studentRepo.save(student));
    }

}
