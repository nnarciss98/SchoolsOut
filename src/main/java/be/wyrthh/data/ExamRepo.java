package be.wyrthh.data;

import be.wyrthh.model.Exam;
import be.wyrthh.service.EntityChecker;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class ExamRepo {

    /* Instances of objects containing the validation methods and entity manager methods to interact with the database */
    EntityManagerMethods emMethods = new EntityManagerMethods();
    EntityChecker eCheck = new EntityChecker();


    /**
     * Insert exam into the database.
     * @param exam
     *          exam to be inserted into the database.
     */
    public void insertExam(Exam exam){
        emMethods.mergeTransaction(exam);
    }

    /**
     * Get the exam entity from the database that has the given ID.
     * @param id
     *          ID of the exam that has to be get from the database
     * @return
     *          Returns the exam with the given ID.
     *          If there is no exam with that given ID, it returns an empty object.
     */
    public Exam getExamById (Long id){
        EntityManager em = EntityManagerProvider.getEM();
        Exam exam = em.find(Exam.class, id);
        return exam;
    }

    /**
     * Update the exam entity in the database, if the exam entity doesn't exist in the database it will be added to the database,
     * if it already exists in the database it will be updated with the new properties.
     * @param exam
     *          Entity to be updated.
     */
    public void updateExam (Exam exam){
        emMethods.mergeTransaction(exam);
    }

    /**
     * Delete the given exam from the database.
     * @param exam
     *          exam entity to be deleted from the database.
     * @return
     *          True if the exam entity has been deleted.
     * @throws TransactionException
     *          Throw exception if there isn't a exam object with the same ID in the database.
     */
    public Boolean deleteExam (Exam exam) throws TransactionException{
        if (eCheck.checkIfExamExists(exam)){
            throw new TransactionException("The exam you are looking for is not to be found (maybe they deleted themselves when they realised what you were going to do...)");
        }
        else {
            emMethods.deleteTransaction(exam);
            return true;
        }
    }
}
