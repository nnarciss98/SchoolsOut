package be.wyrthh.data;

import be.wyrthh.model.User;
import be.wyrthh.service.EntityChecker;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class UserRepo {

    /* Instances of objects containing the validation methods and entity manager methods to interact with the database */
    EntityManagerMethods emMethods = new EntityManagerMethods();
    EntityChecker eCheck = new EntityChecker();

    /**
     * Insert User into the database.
     * @param user
     *          User to be inserted into the database.
     */
    public void insertUser(User user){
        emMethods.mergeTransaction(user);
    }

    /**
     * Get the User entity from the database that has the given ID.
     * @param login
     *          ID of the User that has to be get from the database
     * @return
     *          Returns the User with the given ID.
     *          If there is no User with that given ID, it returns an empty object.
     */
    public User getUserByLogin (String login){
        EntityManager em = EntityManagerProvider.getEM();
        User user = em.find(User.class, login);
        return user;
    }

    /**
     * Update the User entity in the database, if the User entity doesn't exist in the database it will be added to the database,
     * if it already exists in the database it will be updated with the new properties.
     * @param user
     *          Entity to be updated.
     */
    public void updateUser (User user){
        emMethods.mergeTransaction(user);
    }

    /**
     * Delete the given User from the database.
     * @param user
     *          User entity to be deleted from the database.
     * @return
     *          True if the User entity has been deleted.
     * @throws TransactionException
     *          Throw exception if there isn't a User object with the same ID in the database.
     */
    public Boolean deleteUser (User user) throws TransactionException{
        if (eCheck.checkIfUserExists(user)){
            throw new TransactionException("The User you are looking for is not to be found (maybe they deleted themselves when they realised what you were going to do...)");
        }
        else {
            emMethods.deleteTransaction(user);
            return true;
        }
    }
}
