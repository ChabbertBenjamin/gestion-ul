package fr.ul.miage.gestion.ul.controllers;

import fr.ul.miage.gestion.ul.assemblers.RenderAssembler;
import fr.ul.miage.gestion.ul.entities.Render;
import fr.ul.miage.gestion.ul.repository.RenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ExposesResourceFor(Render.class)
public class RenderController {

    private final RenderRepository renderRepository;
    private final RenderAssembler renderAssembler;

    @GetMapping
    public ResponseEntity<?> getAllRenderByStudentIdAndCourseId(@PathVariable("studentId") String studentId, @PathVariable("courseId") String courseId) {
        Iterable<Render> allRender = renderRepository.findAllByStudentIdAndCourseId(studentId,courseId);
        return ResponseEntity.ok(renderAssembler.toCollectionModel(allRender));
    }

}
