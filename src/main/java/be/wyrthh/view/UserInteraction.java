package be.wyrthh.view;

import be.wyrthh.data.*;

import java.util.Scanner;

public class UserInteraction {

    public void basicUserCommandInterface() {
        Boolean condition = true;
        do{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hi, welcome to the main menu, please choose the number for the sub-section that better suits your needs: ");
            System.out.println("Oh, and please, use just integers here, otherwise it will break, and given that I warned you, it'll be your fault for not following the use instructions (:");
            System.out.println("(1) Course related");
            System.out.println("(2) Exam related");
            System.out.println("(3) Grade related");
            System.out.println("(4) Module related");
            System.out.println("(5) Person related");
            System.out.println("(6) User related");
            int userInput = keyboard.nextInt();
            chooseFurtherDirectionOfService(userInput, keyboard);
            if (userInput < 0 || userInput > 6 ){
                condition = false;
            }
        }
        while (condition == true);

    }

    /**
     * Depending on what the user will chose as the service they want to access, this method will give to the user the options they want to get at.
     * @param numberOfService
     *          The number of the menu
     * @param keyboard
     */
    private void chooseFurtherDirectionOfService(int numberOfService, Scanner keyboard){
        if (numberOfService == 1){
            courseRelatedInteractions(keyboard);
        }
        else if (numberOfService == 2){
            examRelatedInteractions(keyboard);
        }
        else if (numberOfService == 3){
            gradeRelatedInteractions(keyboard);
        }
        else if (numberOfService == 4){
            moduleRelatedInteractions(keyboard);
        }
        else if (numberOfService == 5){
            personRelatedInteractions(keyboard);
        }
        else if (numberOfService == 6){
            userRelatedInteractions(keyboard);
        }
        else {
            System.out.println("Not an available option, bye.");
        }
    }


    private void courseRelatedInteractions(Scanner keyboard) {
        CourseRepo courseRepo = new CourseRepo();
        printOptions();


    }

    private void examRelatedInteractions(Scanner keyboard) {
        ExamRepo examRepo = new ExamRepo();
        printOptions();
        int userInput = keyboard.nextInt();
        switch (userInput){
            // Case where the user wants to create a new exam object and add it to the DB
            case 1:
                //TODO finish this up, and the rest of the cases
                examRepo.insertExam(newExam);
                break;
            //Case where the user wants to get an exam from the database
            case 2:
                System.out.printf("For now you can retrieve exams from the database only if you have the exam ID");
                System.out.printf("What is the ID of the exam you want to get?");
                long examID = keyboard.nextLong();
                examRepo.getExamById(examID).toString();
                break;
        }

    }

    private void gradeRelatedInteractions(Scanner keyboard) {
        GradeRepo gradeRepo = new GradeRepo();
        printOptions();
    }

    private void moduleRelatedInteractions(Scanner keyboard) {
        ModuleRepo moduleRepo = new ModuleRepo();
        printOptions();
    }

    private void personRelatedInteractions(Scanner keyboard) {
        PersonRepo personRepo = new PersonRepo();
        printOptions();
    }

    private void userRelatedInteractions(Scanner keyboard) {
        UserRepo userRepo = new UserRepo();
        printOptions();
    }

    /**
     * Function that will tell the user the options they have with the category they've chosen.
     */
    private void printOptions(){
        System.out.println("What do you want to do in this category?");
        System.out.println("(Again please use only the given numbers, otherwise it might crash...)");
        System.out.println("(1) Create entity.");
        System.out.println("(2) Read entity.");
        System.out.println("(3) Update entity.");
        System.out.println("(4) Delete entity.");
    }
}
