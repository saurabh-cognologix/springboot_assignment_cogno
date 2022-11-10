package com.demo.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="student_table1")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Column(name="student_name",nullable = false,length = 15)
    private String studentName;

    @Column(name="student_average_marks")
    private String studentAverageMarks;


}
