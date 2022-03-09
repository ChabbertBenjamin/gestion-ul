package fr.ul.miage.gestion.ul.repository;

import fr.ul.miage.gestion.ul.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
