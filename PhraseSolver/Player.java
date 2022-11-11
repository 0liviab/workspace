package PhraseSolver;
import java.util.Scanner;

public class Player {

    public static void main(String[] args){
        //player's name from input
        //2 player game, alternate btw them (keep guessing til wrong, then switch to other person)
        

    }

    public String getName1(){
    System.out.println("\n\nHello Player 1! What is your name?");
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
    }

    public String getName2(){
    System.out.println("\n\nHello Player 2! What is your name?");
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
    }
}
