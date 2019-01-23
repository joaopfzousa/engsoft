package edu.ufp.sweng.demotests.controllers;

import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.services.DegreeServiceI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/degree")
public class DegreeController {

    private DegreeServiceI degreeServiceI;

    public DegreeController(DegreeServiceI degreeServiceI) {
        this.degreeServiceI = degreeServiceI;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Set<Degree> getDegrees(){
        return degreeServiceI.getDegrees();
    }

    @GetMapping(value = "{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Degree getDegreeByName(@PathVariable String name){
        Optional<Degree> optionalDegree= degreeServiceI.getDegreeByName(name);
        return optionalDegree.orElse(null);

    }
}
