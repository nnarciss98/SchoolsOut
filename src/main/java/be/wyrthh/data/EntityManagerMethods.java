package be.wyrthh.data;

import be.wyrthh.model.Course;

import javax.persistence.EntityManager;

public class EntityManagerMethods {

    /**
     * Merges the given object and commits the transaction
     * @param object
     *          Object to be merged to the database.
     */
    public void mergeTransaction(Object object){
        EntityManager em = EntityManagerProvider.getEM();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        em.close();
    };

    /**
     * Persists the object and commits the transaction.
     * @param object
     *          Object to be persisted to the database.
     */
    public void persistTransaction(Object object){
        EntityManager em = EntityManagerProvider.getEM();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Deletes the object and commits the transaction
     * @param object
     *          Object to be deleted from the database.
     */
    public void deleteTransaction(Object object) {
        EntityManager em = EntityManagerProvider.getEM();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        em.close();
    }
}
