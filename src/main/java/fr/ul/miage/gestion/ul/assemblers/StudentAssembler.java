package fr.ul.miage.gestion.ul.assemblers;

import fr.ul.miage.gestion.ul.controllers.RenderController;
import fr.ul.miage.gestion.ul.controllers.StudentController;
import fr.ul.miage.gestion.ul.entities.Student;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentAssembler implements RepresentationModelAssembler<Student, EntityModel<Student>> {
    @Override
    public EntityModel<Student> toModel(Student student) {
        return EntityModel.of(student,
                linkTo(methodOn(StudentController.class)
                        .getOneStudentById(student.getId())).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Student>> toCollectionModel(Iterable<? extends Student> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }


}
