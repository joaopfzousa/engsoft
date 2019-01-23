package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Degree;

import java.util.Optional;
import java.util.Set;

public interface DegreeServiceI {
    void save(Degree degree);

    Set<Degree> getDegrees();

    Set<Degree> getRepoDegrees();

    Optional<Degree> getDegreeByName(String name);
}
