package com.demo.controllers;

import com.demo.model.Student;
import com.demo.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    //     consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE

    //get all books handler
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Student>> getStudents() {
       List<Student> studentList =  this.studentServices.getAllStudent();
       if(studentList.size()<=0){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }else{
           return ResponseEntity.of(Optional.of(studentList));
       }
    }

    //get single book handler
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Student> getSingleStudent(@PathVariable("id") Integer id) {
        Student student =  this.studentServices.getSingleStudent(id);
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.of(Optional.of(student));
        }
    }

    //new book handler(create)
    @RequestMapping(value = "/students", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        System.out.println(student);
        Student student1 = null;
        try {
            student1 = this.studentServices.addStudent(student);
            return ResponseEntity.of(Optional.of(student1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    //delete book handler
    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Integer studentId) {
        try{
            this.studentServices.deleteSingleStudent(studentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update book handler
    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("studentId") Integer studentId) {
        try{
            this.studentServices.updateStudent(student, studentId);
            return ResponseEntity.ok().body(student);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
