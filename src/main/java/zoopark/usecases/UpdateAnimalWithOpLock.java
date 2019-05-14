package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.entities.Animal;
import zoopark.interceptors.LogAspect;
import zoopark.persistance.AnimalsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Specializes;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
@Path("/animal")
@Getter
@Setter
@Specializes
public class UpdateAnimalWithOpLock extends UpdateAnimal implements IUpdateAnimal, Serializable {

    private Animal animal;

    @Inject
    private AnimalsDAO animalsDAO;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer animalId = Integer.parseInt(requestParameters.get("animalId"));
        this.animal = animalsDAO.findOne(animalId);
    }

    @Transactional
    @LogAspect
    public String updateAnimalName(){
        try {
            animalsDAO.update(this.animal);
        } catch (OptimisticLockException e){
            return "/animalDetails?faces-redirect=true&animalId=" +
                    this.animal.getId() +
                    "&error=optimistic-lock-exception";
        }
        return "animals?faces-redirect=true&buildingId=" +
                this.animal.getBuilding().getId();
    }
}
