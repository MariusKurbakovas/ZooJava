package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.mybatis.dao.AnimalMapper;
import zoopark.mybatis.dao.BuildingMapper;
import zoopark.mybatis.model.Animal;
import zoopark.mybatis.model.Building;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class AnimalsForBuildingMyBatis {
    @Inject
    private BuildingMapper buildingMapper;

    @Inject
    private AnimalMapper animalMapper;

    @Getter
    @Setter
    private Building building;

    @Getter
    @Setter
    private List<Animal> animalsForBuilding;

    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer buildingId = Integer.parseInt(requestParameters.get("buildingId"));
        this.building = buildingMapper.selectByPrimaryKey(buildingId);
        this.animalsForBuilding = animalMapper.selectByBuildingId(buildingId);
    }

    @Transactional
    public String createAnimal() {
        animalToCreate.setBuildingId(this.building.getId());
        animalMapper.insert(animalToCreate);
        return "/myBatis/animals?faces-redirect=true&buildingId=" + this.building.getId();
    }
}
