package be.wyrthh.view;

import be.wyrthh.data.*;
import be.wyrthh.model.Exam;
import be.wyrthh.model.User;

import java.time.LocalDate;
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

    /**
     * This method contains all the interactions related to exam entities
     * @param keyboard
     *          The already existing scanner, that way we won't need to create a new scanner object each time :)
     */
    private void examRelatedInteractions(Scanner keyboard) {
        ExamRepo examRepo = new ExamRepo();
        printOptions();
        int userInput = keyboard.nextInt();
        switch (userInput){
            // Case where the user wants to create a new exam object and add it to the DB
            case 1:
                //TODO finish this up, and the rest of the cases
                System.out.println("So... Form filling time :)");
                System.out.println("Name: ");
                String examName = keyboard.nextLine();
                System.out.println("Description: ");
                String examDescription = keyboard.nextLine();
                System.out.println("Date: ");
                System.out.println("- Year:");
                int year = keyboard.nextInt();
                System.out.println("- Month: ");
                int month = keyboard.nextInt();
                System.out.println("- Day: ");
                int day = keyboard.nextInt();
                LocalDate dateExam = LocalDate.of(year, month, day);
                System.out.println("Weight: ");
                int weightExam = keyboard.nextInt();
                System.out.println("Total: ");
                int totalExam = keyboard.nextInt();

                Exam newExam = new Exam()
                        .setName(examName)
                        .setDescription(examDescription)
                        .setDate(dateExam)
                        .setWeight(weightExam)
                        .setTotal(totalExam);
                examRepo.insertExam(newExam);
                break;
            //Case where the user wants to get an exam from the database
            case 2:
                System.out.println("For now you can retrieve exams from the database only if you have the exam ID");
                System.out.println("What is the ID of the exam you want to get?");
                long examID = keyboard.nextLong();
                examRepo.getExamById(examID).toString();
                break;
            // We give the user the possibility to select what wants to be updated
            // Then depending on what the user chose, we give the user the possibility to change what they chose
            // If the user wants to change multiple things, they have to go back to the beginning of the menu each time they want to change another characteristic
            //          (Sorry, I'm not gonna spend even more time trying to do that, I already know how to, and it's just going to uselessly consume my time :P)
            case 3:
                System.out.printf("ID of the exam you want to update: ");
                long neededExamID = keyboard.nextLong();
                Exam examToBeUpdated = examRepo.getExamById(neededExamID);
                System.out.println("What do you want to update?");
                System.out.println("(1) Name");
                System.out.println("(2) Description");
                System.out.println("(3) Weight");
                System.out.println("(4) Total");
                int userUpdateSelection = keyboard.nextInt();
                // Here we update the name of the exam
                if (userUpdateSelection == 1){
                    System.out.println("What is the new name you want to give the exam?");
                    String nameOfTheUpdatedExam = keyboard.nextLine();
                    examToBeUpdated.setName(nameOfTheUpdatedExam);
                    examRepo.updateExam(examToBeUpdated);
                }
                break;
            // Delete the exam the user chooses
            case 4:
                System.out.printf("What is the ID of the exam you want to delete?");
                long examToBeDeletedID = keyboard.nextLong();
                examRepo.deleteExam(examRepo.getExamById(examToBeDeletedID));
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

    /**
     * This method contains all the interactions related to user entities
     * @param keyboard
     *          The already existing scanner, that way we won't need to create a new scanner object each time :)
     */
    private void userRelatedInteractions(Scanner keyboard) {
        UserRepo userRepo = new UserRepo();
        printOptions();
        int userInput = keyboard.nextInt();
        switch (userInput){
            //Create entity
            case 1:
                System.out.println("User Login: ");
                String userLogin = keyboard.nextLine();
                System.out.println("User password hash: (I know that this formulated this way sounds stupid, but it's just a proof of concept)");
                String passHashUser = keyboard.nextLine();
                //Each user starts as active (otherwise why would you make one?)
                Boolean activeUser = true;

            //Read entity
            case 2:
                System.out.println("Login of the user you are looking for: ");
                String loginInput = keyboard.nextLine();
                userRepo.getUserByLogin(loginInput).toString();

            //Update entity
            case 3:
                System.out.println("Login of the user you want to update: ");
                String loginUserToBeUpdated = keyboard.nextLine();
                User userToBeUpdated = userRepo.getUserByLogin(loginUserToBeUpdated);
                System.out.println("Is the person still active?");
                System.out.println("(1) Yes");
                System.out.println("(2) No");
                int isUserActive = keyboard.nextInt();
                userToBeUpdated.setActive((isUserActive == 1 ) ? true : false);
                System.out.println("There should be an option to also update the person of the user, nog gonna complicate it for now as this is just a proof of concept.");
                userRepo.updateUser(userToBeUpdated);

            //Delete entity
            case 4:
                System.out.println("Login of the user you want to delete: ");
                String userToBeDeleted = keyboard.nextLine();
                userRepo.deleteUser(userRepo.getUserByLogin(userToBeDeleted));
        }
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
