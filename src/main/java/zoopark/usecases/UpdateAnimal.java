package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.entities.Animal;
import zoopark.interceptors.LogAspect;
import zoopark.persistance.AnimalsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
@Getter @Setter
public class UpdateAnimal implements IUpdateAnimal, Serializable {

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
        animalsDAO.update(this.animal);
        return "animals?faces-redirect=true&buildingId=" +
                this.animal.getBuilding().getId();
    }
}
