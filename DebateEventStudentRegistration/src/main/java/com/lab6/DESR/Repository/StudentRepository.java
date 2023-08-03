package com.lab6.DESR.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab6.DESR.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
