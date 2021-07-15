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
public class Course {
    @Id
    @SequenceGenerator( name = "course_seq" , sequenceName = "course_seq" , initialValue = 1000, allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "course_seq")
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
                cascade = CascadeType.ALL,
                optional = true,
                fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}
