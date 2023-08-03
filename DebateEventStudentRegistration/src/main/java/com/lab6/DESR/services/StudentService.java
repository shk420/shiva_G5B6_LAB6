package com.lab6.DESR.services;

import java.util.List;

import com.lab6.DESR.Model.Student;


public interface StudentService {
	
	Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student, long id);

    void deleteStudent(Long id);

}
