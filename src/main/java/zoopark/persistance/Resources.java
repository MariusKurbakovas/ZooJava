package zoopark.persistance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.SynchronizationType;

@ApplicationScoped
public class Resources {

    @PersistenceUnit(unitName = "AnimalsPU")
    private EntityManagerFactory emf;// = Persistence.createEntityManagerFactory("AnimalsPU");

    @Produces
    @RequestScoped
    private EntityManager createJTAEntityManager() {
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }

    private void closeDefaultEntityManager(@Disposes EntityManager em) {
        em.close();
    }
}
