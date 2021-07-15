package com.personal.courses;

import com.personal.courses.entity.*;
import com.personal.courses.repository.CourseMaterialRepository;
import com.personal.courses.repository.CourseRepository;
import com.personal.courses.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class StudentCourseApiApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseMaterialRepository materialRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void saveStudent() {
		Guardian guardian = new Guardian("Ananth","ananth.annamalai.19@gmail.com","99999999999");
		Student student = Student.builder()
				.firstName("Sasikala")
				.lastName("Ananth")
				.email("sasi.muthaiyan@gmail.com")
				.guardian(guardian).build();

		studentRepository.save(student);

	}

	@Test
	void getAllStudents() {
		List<Student> students = studentRepository.findAll();
		for (Student student: students ) {
			System.out.println(student.toString());
		}
	}

	@Test
	void getStudentsByFirstName() {
		List<Student> students = studentRepository.findByFirstNameContaining("sasi");
		for (Student student: students ) {
			System.out.println(student.toString());
		}
	}

	@Test
	void getStudentsByGuardianName() {
		List<Student> students = studentRepository.findByGuardianNameContaining("An");
		for (Student student: students ) {
			System.out.println(student.toString());
		}
	}

	@Test
	void getStudentByEmail() {
		Student student = studentRepository.getStudentByEmail("ananth.annamalai.19@gmail.com");
		System.out.println(student.toString());
	}

	@Test
	void getStudentByEmailNative() {
		Student student = studentRepository.getStudentByEmailNative("ananth.annamalai.19@gmail.com");
		System.out.println(student.toString());
	}

	@Test
	void updateStudentByEmailNative() {
		studentRepository.updateLastNameByEmail("Annamalai updated","ananth.annamalai.19@gmail.com");
		Student student = studentRepository.getStudentByEmailNative("ananth.annamalai.19@gmail.com");
		System.out.println(student.toString());
	}

	@Test
	void saveCourseMaterial() {
		Course course = Course.builder()
							.title("DSA")
							.credit(6).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("google.com").course(course).build();
		materialRepository.save(courseMaterial);
	}

	@Test
	void saveCourseWithTeacher() {
		Course course = Course.builder()
				.title("DSA")
				.teacher(Teacher.builder().firstName("John").lastName("Smith").build())
				.credit(6).build();
		courseRepository.save(course);
	}

	@Test
	void findAllWithPagination() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		List<Student> students = studentRepository.findAll(firstPageWithTwoElements).getContent();
		System.out.println(" Total Elements => "+studentRepository.findAll(firstPageWithTwoElements).getTotalElements());
		System.out.println(" Total Pages => "+studentRepository.findAll(firstPageWithTwoElements).getTotalPages());
		for (Student student: students ) {
			System.out.println(student.toString());
		}
	}

	@Test
	void findAllWithSortPagination() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2, Sort.by("email").descending().and(Sort.by("lastName")));
		List<Student> students = studentRepository.findAll(firstPageWithTwoElements).getContent();
		System.out.println(" Total Elements => "+studentRepository.findAll(firstPageWithTwoElements).getTotalElements());
		System.out.println(" Total Pages => "+studentRepository.findAll(firstPageWithTwoElements).getTotalPages());
		for (Student student: students ) {
			System.out.println(student.toString());
		}
	}

	@Test
	void findByTitleContaining() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		List<Course> students = courseRepository.findByTitleContaining("D",firstPageWithTwoElements).getContent();
		System.out.println(" Total Elements => "+courseRepository.findByTitleContaining("D",firstPageWithTwoElements).getTotalElements());
		System.out.println(" Total Pages => "+courseRepository.findByTitleContaining("D",firstPageWithTwoElements).getTotalPages());
		for (Course course: students ) {
			System.out.println(course.toString());
		}
	}



}
