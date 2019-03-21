package zoopark.usecases;

import lombok.Getter;
import lombok.Setter;
import zoopark.entities.Animal;
import zoopark.persistance.AnimalsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Animals {

    public Animals() {

    }

    @Inject
    private AnimalsDAO animalsDAO;

    @Getter @Setter
    private Animal animalToCreate = new Animal();

    @Getter
    private List<Animal> allAnimals;

    @PostConstruct
    public void init() {
        loadAllAnimals();
    }

    @Transactional
    public String createAnimal(){
        this.animalsDAO.persist(animalToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllAnimals(){
        this.allAnimals = animalsDAO.loadAll();
    }
}
