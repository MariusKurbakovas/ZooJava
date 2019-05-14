package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.mybatis.dao.BuildingMapper;
import zoopark.mybatis.model.Building;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class BuildingsMyBatis {
    public BuildingsMyBatis() {
    }

    @Inject
    private BuildingMapper buildingMapper;

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
        this.buildingMapper.insert(buildingToCreate);
        return "/myBatis/buildings?faces-redirect=true";
    }

    private void loadAllBuildings(){
        this.allBuildings = buildingMapper.selectAll();
    }

}
