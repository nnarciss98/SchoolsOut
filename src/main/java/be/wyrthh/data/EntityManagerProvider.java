package be.wyrthh.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Doesn't quite work yet, gives a NullPointerException,
 */
public class EntityManagerProvider {

    private static EntityManagerFactory emf;

    public EntityManagerProvider() { emf = Persistence.createEntityManagerFactory("persistence");
    }

    public static EntityManager getEM(){
        return emf.createEntityManager();
    }

}