package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Degree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DegreeRepo extends CrudRepository<Degree,Long> {
    Optional<Degree> findByName(String name);
}
