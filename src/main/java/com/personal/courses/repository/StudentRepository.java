package com.personal.courses.repository;

import com.personal.courses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByGuardianNameContaining(String firstName);

    @Query("select s from Student s where email = ?1")
    Student getStudentByEmail(String email);

    @Query(value = "select * from student s where email_address = :email" , nativeQuery = true)
    Student getStudentByEmailNative(String email);

    @Modifying
    @Transactional
    @Query(value = "update student set last_name = :lastName where email_address = :email ",nativeQuery = true)
    void updateLastNameByEmail(String lastName, String email);
}
