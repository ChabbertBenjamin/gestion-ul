package fr.ul.miage.gestion.ul.repository;

import fr.ul.miage.gestion.ul.entities.Render;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenderRepository extends JpaRepository<Render, String> {
    Iterable<Render> findAllByStudentIdAndCourseId(String studentId, String courseId);
}
