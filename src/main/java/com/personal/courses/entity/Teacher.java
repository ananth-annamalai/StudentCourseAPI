package com.personal.courses.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator( name = "teacher_seq" , sequenceName = "teacher_seq" , initialValue = 1000, allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    private Long teacherId;
    private String firstName;
    private String lastName;
}
