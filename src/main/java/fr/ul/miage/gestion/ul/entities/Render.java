package fr.ul.miage.gestion.ul.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Render {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String file;
    private String deadLine;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;



}
