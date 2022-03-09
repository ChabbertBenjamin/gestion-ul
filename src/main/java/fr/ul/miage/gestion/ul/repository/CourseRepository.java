package fr.ul.miage.gestion.ul.repository;

import fr.ul.miage.gestion.ul.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
