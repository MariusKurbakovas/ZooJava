package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.entities.Building;
import zoopark.persistance.BuildingsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Buildings {
    public Buildings() {

    }

    @Inject
    private BuildingsDAO buildingsDAO;

    @Getter
    @Setter
    private Building buildingToCreate = new Building();

    @Getter
    private List<Building> allBuildings;

    @PostConstruct
    public void init() {
        loadAllBuildings();
    }

    @Transactional
    public String createBuilding(){
        this.buildingsDAO.persist(buildingToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllBuildings(){
        this.allBuildings = buildingsDAO.loadAll();
    }
}
