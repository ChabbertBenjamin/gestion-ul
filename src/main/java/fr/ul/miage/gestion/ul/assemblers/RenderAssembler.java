package fr.ul.miage.gestion.ul.assemblers;

import fr.ul.miage.gestion.ul.controllers.RenderController;
import fr.ul.miage.gestion.ul.entities.Render;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RenderAssembler implements RepresentationModelAssembler<Render, EntityModel<Render>> {
    @Override
    public EntityModel<Render> toModel(Render render) {
        String studentId = render.getStudent().getId();
        String courseId = render.getCourse().getId();
        return EntityModel.of(render,
                linkTo(methodOn(RenderController.class)
                        .getAllRenderByStudentIdAndCourseId(studentId, courseId)).withSelfRel());

    }

    @Override
    public CollectionModel<EntityModel<Render>> toCollectionModel(Iterable<? extends Render> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
