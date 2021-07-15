package com.personal.courses.repository;

import com.personal.courses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
