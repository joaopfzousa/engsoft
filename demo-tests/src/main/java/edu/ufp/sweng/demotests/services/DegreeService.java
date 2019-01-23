package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.repositories.DegreeRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DegreeService implements DegreeServiceI {

    private DegreeRepo degreeRepo;

    public DegreeService(DegreeRepo degreeRepo) {
        this.degreeRepo = degreeRepo;
    }

    @Override
    public void save(Degree degree){
        this.degreeRepo.save(degree);
    }

    @Override
    public Set<Degree> getDegrees(){
        return getRepoDegrees();
    }

    @Override
    public Set<Degree> getRepoDegrees(){
        Set<Degree> degrees=new HashSet<>();
        for(Degree degree:this.degreeRepo.findAll()){
            degrees.add(degree);
        }
        return degrees;
    }

    @Override
    public Optional<Degree> getDegreeByName(String name) {
        return this.degreeRepo.findByName(name);
    }
}
