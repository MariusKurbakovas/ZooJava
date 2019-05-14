package zoopark.rest;

import lombok.*;
import zoopark.entities.Animal;
import zoopark.persistance.AnimalsDAO;
import zoopark.persistance.BuildingsDAO;
import zoopark.rest.contracts.AnimalDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/animals")
public class AnimalsController {

    @Inject
    @Setter @Getter
    private AnimalsDAO animalsDAO;

    @Inject
    @Setter @Getter
    private BuildingsDAO buildingsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        Animal animal = animalsDAO.findOne(id);
        if (animal == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AnimalDto animalDto = new AnimalDto();
        animalDto.setName(animal.getName());
        animalDto.setBuildingName(animal.getBuilding().getName());

        return Response.ok(animalDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer animalId,
            AnimalDto animalData) {
        try {
            Animal existingAnimal = animalsDAO.findOne(animalId);
            if (existingAnimal == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingAnimal.setName(animalData.getName());
            animalsDAO.update(existingAnimal);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(AnimalDto animalData) {
        Animal animal = new Animal();
        animal.setBuilding(buildingsDAO.findOne(animalData.getBuildingId()));
        animal.setName(animalData.getName());
        animalsDAO.persist(animal);
        return Response.ok().build();
    }
}
