package be.wyrthh.data;

import be.wyrthh.model.Grade;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class GradeRepo {

    /* Instances of objects containing the validation methods and entity manager methods to interact with the database */
    EntityManagerMethods emMethods = new EntityManagerMethods();


    /**
     * Insert grade into the database.
     * @param grade
     *          Grade to be inserted into the database.
     */
    public void insertGrade(Grade grade){
        emMethods.mergeTransaction(grade);
    }

    /**
     * Get the Grade entity from the database that has the given ID.
     * @param id
     *          ID of the grade that has to be get from the database
     * @return
     *          Returns the grade with the given ID.
     *          If there is no grade with that given ID, it returns an empty object.
     */
    public Grade getGradeById (Long id){
        EntityManager em = EntityManagerProvider.getEM();
        Grade grade = em.find(Grade.class, id);
        return grade;
    }

    /**
     * Update the grade entity in the database, if the grade entity doesn't exist in the database it will be added to the database.
     * @param grade
     *          Entity to be updated.
     */
    public void updateGrade (Grade grade){
        if (getGradeById(grade.getId()) != null) {
            emMethods.mergeTransaction(grade);
        }
    }

    /**
     * Delete the given grade from the database.
     * @param grade
     *          grade entity to be deleted from the database.
     * @return
     *          True if the grade entity has been deleted.
     * @throws TransactionException
     *          Throw exception if there isn't a grade object with the same ID in the database.
     */
    public Boolean deleteGrade (Grade grade) throws TransactionException{
        if (getGradeById(grade.getId()) == null){
            throw new TransactionException("The grade you are looking for is not to be found (maybe they deleted themselves when they realised what you were going to do...)");
        }
        else {
            emMethods.deleteTransaction(grade);
            return true;
        }
    }
}
