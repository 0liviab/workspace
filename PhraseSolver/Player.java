package PhraseSolver;
import java.util.Scanner;

public class Player {

    public static void main(String[] args){
        //player's name from input
        //2 player game, alternate btw them (keep guessing til wrong, then switch to other person)
        

    }

    public static String getName(){
System.out.println("Hello Player! What is your name?");
    Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    return name;
    }
}
