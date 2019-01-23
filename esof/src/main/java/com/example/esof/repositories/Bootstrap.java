/**package com.example.esof.repositories;

import com.example.esof.models.Degree;
import com.example.esof.models.Student;
import com.example.esof.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private DegreeRepoI degreeRepoI;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }


}
**/

package com.example.esof.repositories;

import com.example.esof.models.Course;
import com.example.esof.models.Degree;
import com.example.esof.models.Student;
import com.example.esof.repositories.DegreeRepoI;
//import com.example.esof.services.DegreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger= LoggerFactory.getLogger(Bootstrap.class);

    private DegreeRepoI degreeService;

    public Bootstrap(DegreeRepoI degreeService) {
        this.degreeService = degreeService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Degree informatica=new Degree("Engenharia Informática");
        Degree civil=new Degree("Engenharia Civil");


        Set<Course> courses=createCoursesFromFile();

        Student st1=new Student("12345",informatica);
        Student st2=new Student("23456",informatica);
        Student st3=new Student("34567",informatica);
        Student st4=new Student("45678",civil);

        Course engSoft=getByName("Engenharia de Software",courses);



        if (engSoft != null) {
            engSoft.addStudent(st1);
            engSoft.addStudent(st2);
            engSoft.addStudent(st3);
        }

        logger.debug(engSoft.toString());

        Course redes1=getByName("Redes de Computadores I",courses);
        if (redes1 != null) {
            redes1.addStudent(st1);
            redes1.addStudent(st3);
        }


        Course arq=getByName("Arquitectura de Computadores",courses);
        if (arq != null) {
            arq.addStudent(st2);
        }

        Course mat2=getByName("Matemática II",courses);
        if (mat2 != null) {
            mat2.addStudent(st4);
        }

        for(Course course:courses){
            informatica.addCourse(course);
        }



        degreeService.save(civil);
        degreeService.save(informatica);



    }

    private Set<Course> createCoursesFromFile() {
        Set<Course> courses=new HashSet<>();
        String line;

        InputStream is = this.getClass().getResourceAsStream("/courses.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            while((line=br.readLine())!=null){
                String attributes[]=line.split(",");

                Course course=new Course(attributes[0],Integer.parseInt(attributes[1]),Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]));
                courses.add(course);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    private Course getByName(String name,Set<Course>courses){
        for(Course course:courses){
            if(course.getName().equalsIgnoreCase(name)){
                return course;
            }
        }
        return null;
    }
}
