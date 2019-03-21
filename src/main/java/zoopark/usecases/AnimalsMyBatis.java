package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.mybatis.dao.AnimalMapper;
import zoopark.mybatis.model.Animal;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AnimalsMyBatis {
    @Inject
    private AnimalMapper animalMapper;

    @Getter
    private List<Animal> allAnimals;

    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @PostConstruct
    public void init(){
        this.loadAllAnimals();
    }

    private void loadAllAnimals() {
        this.allAnimals = animalMapper.selectAll();
    }

    @Transactional
    public String createAnimal(){
        animalMapper.insert(animalToCreate);
        return "/myBatis/animals?faces-redirect=true";
    }
}
