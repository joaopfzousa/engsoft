package com.example.esof.repositories;

import com.example.esof.models.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DegreeRepoI extends CrudRepository<Degree,Long> {
    Degree findByName(String name);
}

