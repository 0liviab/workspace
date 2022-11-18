package PhraseSolver;

import java.util.Scanner;

public class Player {

    public static void main(String[] args) {
        // player's name from input
        // 2 player game, alternate btw them (keep guessing til wrong, then switch to
        // other person)

    }

    String name = "";

    // gets player one's name
    public String getName1() {
        System.out.println("Hello Player 1! What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }

    // gets player two's name
    public String getName2() {
        System.out.println("Hello Player 2! What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }
}
