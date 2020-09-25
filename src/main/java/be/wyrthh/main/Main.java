package be.wyrthh.main;

import be.wyrthh.view.UserInteraction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");
        EntityManager em = emf.createEntityManager();
        UserInteraction userInteraction = new UserInteraction();

        userInteraction.basicUserCommandInterface();

    }
}
