package ma.quantorion.appquitue.internshiprest.domain.assembler;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.internshiprest.api.InternshipController;
import ma.quantorion.appquitue.internshiprest.domain.Internship;

@Component
public class InternshipModelAssembler implements RepresentationModelAssembler<Internship, EntityModel<Internship>>
{
	@Override
	public EntityModel<Internship> toModel(Internship internship)
	{
			
		return EntityModel.of(internship,
				linkTo(methodOn(InternshipController.class).getInternship(internship.getInternshipId())).withSelfRel(),
				linkTo(methodOn(InternshipController.class).getInternships()).withRel("Internships"));
	}

}
