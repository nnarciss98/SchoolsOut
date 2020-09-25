package be.wyrthh.view;

import java.util.Scanner;

public class UserInteraction {

    public void basicUserCommandInterface(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, welcome to the main menu, please choose the number for the sub-section that better suits your needs: (I'm not going to make it for you, haven't got to that point of AI yet");
        System.out.println("Oh, and please, use just integers here, otherwise it will break, and given that I warned you, it'll be your fault for not following the use instructions (:");
        System.out.println("(1) Course related");
        System.out.println("(2) Exam related");
        System.out.println("(3) Grade related");
        System.out.println("(4) Module related");
        System.out.println("(5) Person related");
        System.out.println("(6) User related");
    }
}
