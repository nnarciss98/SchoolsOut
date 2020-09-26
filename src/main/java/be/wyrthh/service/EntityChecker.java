package be.wyrthh.service;

import be.wyrthh.data.*;
import be.wyrthh.model.*;
import be.wyrthh.model.Module;


public class EntityChecker {

    /* Instance of CourseRepo to use methods from that class */
    CourseRepo courseRepo = new CourseRepo();

    /**
     * Check if the given course exists in the database.
     * @param course
     *          Course entity that we'll look up in the database.
     * @return
     *          True if the course exists in the database.
     *          False if the course doesn't exist in the database.
     */
    public Boolean checkIfCourseExists(Course course) {
        if (courseRepo.getCourseById(course.getId()) == null){
            return false;
        }
        else {
            return true;
        }
    }

    /* Instance of ExamRepo to use methods from that class */
    ExamRepo examRepo = new ExamRepo();

    /**
     * Check if the given exam exists in the database.
     * @param exam
     *          Exam entity that we'll look up in the database.
     * @return
     *          True if the exam exists in the database.
     *          False if the exam doesn't exist in the database.
     */
    public Boolean checkIfExamExists(Exam exam) {
        if (examRepo.getExamById(exam.getId()) == null){
            return false;
        }
        else {
            return true;
        }
    }


    /* Instance of ModuleRepo to use methods from that class */
    ModuleRepo moduleRepo = new ModuleRepo();

    /**
     * Check if the given module exists in the database.
     * @param module
     *          Module entity that we'll look up in the database.
     * @return
     *          True if the module exists in the database.
     *          False if the module doesn't exist in the database.
     */
    public Boolean checkIfModuleExists(Module module){
        if (moduleRepo.getmoduleById(module.getId()) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /* Instance of PersonRepo to use methods from that class */
    PersonRepo personRepo = new PersonRepo();

    /**
     * Check if the given person exists in the database.
     * @param person
     *          Person entity that we'll look up in the database.
     * @return
     *          True if the person exists in the database.
     *          False if the person doesn't exist in the database.
     */
    public Boolean checkIfPersonExists(Person person){
        if (personRepo.getPersonById(person.getId()) == null){
            return false;
        }
        else {
            return true;
        }
    }

    /* Instance of UserRepo to use methods from that class */
    UserRepo userRepo = new UserRepo();

    /**
     * Check if the given user exists in the database.
     * @param user
     *          User entity that we'll look up in the database.
     * @return
     *          True if the user exists in the database.
     *          False if the user doesn't exist in the database.
     */
    public Boolean checkIfUserExists(User user){
        if(userRepo.getUserByLogin(user.getLogin()) == null){
            return false;
        }
        else {
            return true;
        }
    }


    /* Instance of UserRepo to use methods from that class */
    GradeRepo gradeRepo = new GradeRepo();

    /**
     * Check if the given user exists in the database.
     * @param grade
     *          User entity that we'll look up in the database.
     * @return
     *          True if the user exists in the database.
     *          False if the user doesn't exist in the database.
     */
    public Boolean checkIfGradeExists(Grade grade){
        if(gradeRepo.getGradeById(grade.getId()) == null){
            return false;
        }
        else {
            return true;
        }
    }



}
