package com.chirango.SpringDataJPAExplore.repository;

import com.chirango.SpringDataJPAExplore.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    //JPQL Query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL Query
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String  getStudentFirstNameByEmailAddress(String emailId);

    //Native SQL Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param SQL Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set email_address = ?1 where first_name = ?2",
            nativeQuery = true
    )
    void updateEmailAddressByStudentFirstName(String emailId, String firstName);
}
