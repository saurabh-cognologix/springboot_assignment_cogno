package com.demo.dao;

import com.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;



public interface StudentRepository extends CrudRepository<Student,Integer> {
   public Student findByStudentId(Integer stuId);
  // public Student findById(Integer id);
}
