package com.chirango.SpringDataJPAExplore.repository;

import com.chirango.SpringDataJPAExplore.entity.Course;
import com.chirango.SpringDataJPAExplore.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(3)
                .build();

        Course courseReact = Course.builder()
                .title("React")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Samantha")
                .lastName("Russell")
                //.courses(List.of(courseDBA, courseReact))
                .build();

        teacherRepository.save(teacher);
    }

}