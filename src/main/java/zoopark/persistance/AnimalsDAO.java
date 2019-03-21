package zoopark.persistance;

import zoopark.entities.Animal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AnimalsDAO {

    public AnimalsDAO(){
    }

    @Inject
    private EntityManager em;

    public List<Animal> loadAll() {
        return em.createNamedQuery("Animal.findAll", Animal.class)
                .getResultList();
    }

    public void persist(Animal animal) { this.em.persist(animal);}
}
