package fr.ul.miage.gestion.ul.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;
    private int capacity;

}
