package zoopark.persistance;

import zoopark.entities.Building;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BuildingsDAO {
    public BuildingsDAO(){
    }

    @Inject
    private EntityManager em;

    public List<Building> loadAll() {
        return em.createNamedQuery("Building.findAll", Building.class)
                .getResultList();
    }

    public void persist(Building building) { this.em.persist(building);}

    public Building findOne(Integer id) {
        return em.find(Building.class, id);
    }
}
