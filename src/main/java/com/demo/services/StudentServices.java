package com.demo.services;

import com.demo.dao.StudentRepository;
import com.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service  //Indicate that annnoted class is sevice class
public class StudentServices {

    @Autowired
    private  StudentRepository studentRepository;

    /* private static List<Student> studentList = new ArrayList<>();
     static {
         studentList.add(new Student(12,"Maximum","420"));
         studentList.add(new Student(13,"Definite","428"));
         studentList.add(new Student(14,"Pendulum","450"));
     }*/

     //get all student
    public List<Student> getAllStudent(){
        return (List<Student>) this.studentRepository.findAll();
    }

    //get single student
    public Student getSingleStudent(Integer id){
        Student student = null;
        try {
            student = this.studentRepository.findByStudentId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    //add new student
    public  Student addStudent(Student student){
         // studentRepository.save(student);
          studentRepository.save(student);
          return student;
    }
    //delete single student by id
    public void deleteSingleStudent(Integer studentId) {
/*        studentList = studentList.stream().filter(e->{
            if(e.getStudentId() != studentId) {
                return true;
            }else {
                return false;
            }
        }).collect(Collectors.toList());*/
        studentRepository.deleteById(studentId);
    }


    //update the book
    public void updateStudent(Student student, Integer studentId) {

       /* studentList.stream().map(e->{
            if(e.getStudentId()==studentId) {
                e.setStudentName(student.getStudentName());
                e.setStudentAverageMarks(student.getStudentAverageMarks());
            }
            return e;
        }).collect(Collectors.toList());*/
        student.setStudentId(studentId);

        studentRepository.save(student);
    }
}
