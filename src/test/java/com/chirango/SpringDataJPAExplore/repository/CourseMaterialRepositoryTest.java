package com.chirango.SpringDataJPAExplore.repository;

import com.chirango.SpringDataJPAExplore.entity.Course;
import com.chirango.SpringDataJPAExplore.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Microservices")
                .credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.microservices.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printALlCourses() {
        List<CourseMaterial> courseMaterialList = repository.findAll();
        System.out.println("CourseMaterials: " + courseMaterialList);
    }
}