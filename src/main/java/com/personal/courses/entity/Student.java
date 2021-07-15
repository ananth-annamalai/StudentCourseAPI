package com.personal.courses.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "student" , uniqueConstraints={@UniqueConstraint(columnNames = "email_address")})
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq", sequenceName= "student_seq",
            initialValue = 1001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}
