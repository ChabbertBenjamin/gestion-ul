package fr.ul.miage.gestion.ul.controllers;

import fr.ul.miage.gestion.ul.assemblers.RenderAssembler;
import fr.ul.miage.gestion.ul.assemblers.StudentAssembler;
import fr.ul.miage.gestion.ul.entities.Render;
import fr.ul.miage.gestion.ul.entities.Student;
import fr.ul.miage.gestion.ul.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentAssembler studentAssembler;
    private final RenderController renderController;
    private final RenderAssembler renderAssembler;

    @GetMapping
    public ResponseEntity<?> getAllStudent() {
        Iterable<Student> allStudent = studentRepository.findAll();
        return ResponseEntity.ok(studentAssembler.toCollectionModel(allStudent));
    }


    @GetMapping(value="/{studentId}")
    public ResponseEntity<?> getOneStudentById(@PathVariable("studentId") String studentId) {
        return Optional.of(studentRepository.findById(studentId)).filter(Optional::isPresent)
                .map(i -> ResponseEntity.ok(studentAssembler.toModel(i.get())))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{studentId}/course/{courseId}/render")
    public ResponseEntity<?> renderHomework(@PathVariable("studentId") String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(renderController.getAllRenderByStudentIdAndCourseId(studentId,courseId));
    }

}
