package be.wyrthh.data;

import be.wyrthh.model.Person;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class PersonRepo {

    /* Instances of objects containing the validation methods and entity manager methods to interact with the database */
    EntityManagerMethods emMethods = new EntityManagerMethods();


    /**
     * Insert person into the database.
     * @param person
     *          Person to be inserted into the database.
     */
    public void insertPerson(Person person){
       emMethods.mergeTransaction(person);
    }

    /**
     * Get the person entity from the database that has the given ID.
     * @param id
     *          ID of the person that has to be get from the database
     * @return
     *          Returns the person with the given ID.
     *          If there is no person with that given ID, it returns an empty object.
     */
    public Person getPersonById (Integer id){
        EntityManager em = EntityManagerProvider.getEM();
        Person person = em.find(Person.class, id);
        return person;
    }

    /**
     * Update the person entity in the database, if the person entity doesn't exist in the database it will be added to the database.
     * @param person
     *          Entity to be updated.
     */
    public void updatePerson (Person person){
        if (getPersonById(person.getId()) != null) {
            emMethods.mergeTransaction(person);
        }
    }

    /**
     * Delete the given person from the database.
     * @param person
     *          Person entity to be deleted from the database.
     * @return
     *          True if the person entity has been deleted.
     * @throws TransactionException
     *          Throw exception if there isn't a person object with the same ID in the database.
     */
    public Boolean deletePerson (Person person) throws TransactionException{
        if (getPersonById(person.getId()) == null){
            throw new TransactionException("The person you are looking for is not to be found (maybe they deleted themselves when they realised what you were going to do...)");
        }
        else {
            emMethods.deleteTransaction(person);
            return true;
        }
    }
}
