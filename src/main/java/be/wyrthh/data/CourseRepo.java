package be.wyrthh.data;

import be.wyrthh.model.Course;
import org.hibernate.TransactionException;

import javax.persistence.EntityManager;

public class CourseRepo {

    EntityManagerMethods emMethods = new EntityManagerMethods();

    /**
     * Inserts the given course in the database.
     * @param course
     *          Course to be inserted in the database.
     */
    public void insertCourse(Course course){
        emMethods.mergeTransaction(course);
    }

    /**
     * Get the course entity from the database that has the given ID.
     * @param id
     *          ID of the course that has to be get from the database.
     * @return
     *          Returns the course with the given ID.
     *          If the course doesn't exist in the database throws an exception.
     */
    public Course getCourseById(long id) throws TransactionException {
        EntityManager em = EntityManagerProvider.getEM();
        Course course = em.find(Course.class, id);
        if (course == null){
            throw new TransactionException("Element not found, are you sure you didn't make a typo? just sayin' u.u");
        }
        return course;
    }

    /**
     * Update the course entity in the database, if the course entity doesn't exist in the database it will be added to the database.
     * @param course
     *          Course to be updated.
     */
    public void updateCourse(Course course){
        if(getCourseById(course.getId()) != null) {
            emMethods.mergeTransaction(course);
        }
    }

    /**
     * Delete the given course from the database
     * @param course
     *          Course to be deleted
     * @return
     *          True if the course has been deleted
     * @throws TransactionException
     *          Thrown exception if the course doesn't exist in the database
     */
    public Boolean deleteCourse(Course course) throws TransactionException{
        if(getCourseById(course.getId()) == null){
            throw new TransactionException("Course not found, try again.");
        }
        else{
            emMethods.deleteTransaction(course);
            return true;
        }
    }
}