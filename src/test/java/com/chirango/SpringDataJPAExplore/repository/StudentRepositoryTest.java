package com.chirango.SpringDataJPAExplore.repository;

import com.chirango.SpringDataJPAExplore.entity.Guardian;
import com.chirango.SpringDataJPAExplore.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.ListIterator;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("micheal@gmail.com")
                .firstName("Micheal")
                .lastName("Velayudham")
//                .guardianName("Arjun")
//                .guardianEmail("arjun@gmail.com")
//                .guardianMobile("7306548899")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Leo")
                .email("leo@gmail.com")
                .mobile("8907899665")
                .build();

        Student student = Student.builder()
                .firstName("Sanjay")
                .lastName("Leo")
                .emailId("snajayleo@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void fetchStudentsByFirstname() {
        List<Student> studentList = studentRepository.findByFirstName("Micheal");

        System.out.println("students = " + studentList);
    }

    @Test
    public void fetchStudentsByFirstnameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("ch");

        System.out.println("students = " + studentList);
    }

    @Test
    public void fetchStudnetsByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("boss");
        System.out.println(studentList);
    }

    @Test
    public void fetchByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("snajay@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("snajay@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("snajay@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("snajay@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateEmailAddressByStudentFirstName("sanjay@gmail.com", "sanjay");
    }
}