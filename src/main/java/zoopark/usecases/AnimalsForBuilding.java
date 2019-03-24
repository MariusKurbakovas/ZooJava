package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.entities.Animal;
import zoopark.entities.Building;
import zoopark.persistance.AnimalsDAO;
import zoopark.persistance.BuildingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class AnimalsForBuilding {
    @Inject
    private BuildingsDAO buildingsDAO;

    @Inject
    private AnimalsDAO animalsDAO;

    @Getter @Setter
    private Building building;

    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer buildingId = Integer.parseInt(requestParameters.get("buildingId"));
        this.building = buildingsDAO.findOne(buildingId);
    }

    @Transactional
    public String createAnimal() {
        animalToCreate.setBuilding(this.building);
        animalsDAO.persist(animalToCreate);
        return "animals?faces-redirect=true&buildingId=" + this.building.getId();
    }
}
