package be.wyrthh.view;

import be.wyrthh.data.*;

import java.util.Scanner;

public class UserInteraction {

    public void basicUserCommandInterface() {
        while (true){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hi, welcome to the main menu, please choose the number for the sub-section that better suits your needs: (I'm not going to make it for you, haven't got to that point of AI yet");
            System.out.println("Oh, and please, use just integers here, otherwise it will break, and given that I warned you, it'll be your fault for not following the use instructions (:");
            System.out.println("(1) Course related");
            System.out.println("(2) Exam related");
            System.out.println("(3) Grade related");
            System.out.println("(4) Module related");
            System.out.println("(5) Person related");
            System.out.println("(6) User related");
            int userInput = keyboard.nextInt();
            chooseFurtherDirectionOfService(userInput, keyboard);
        }

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
            System.out.println("Not an available option, try again.");
        }
    }


    private void courseRelatedInteractions(Scanner keyboard) {
        CourseRepo courseRepo = new CourseRepo();

    }

    private void examRelatedInteractions(Scanner keyboard) {
        ExamRepo examRepo = new ExamRepo();
    }

    private void gradeRelatedInteractions(Scanner keyboard) {
        GradeRepo gradeRepo = new GradeRepo();
    }

    private void moduleRelatedInteractions(Scanner keyboard) {
        ModuleRepo moduleRepo = new ModuleRepo();
    }

    private void personRelatedInteractions(Scanner keyboard) {
        PersonRepo personRepo = new PersonRepo();
    }

    private void userRelatedInteractions(Scanner keyboard) {
        UserRepo userRepo = new UserRepo();
    }
}
