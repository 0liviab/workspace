import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Asks the user to input their name for the player
        System.out.println("What is player 1's name?: ");
        String p1Name = sc.nextLine();
        Player p1 = new Player(p1Name);
        //DONE: Create Player 1

        //Asks the user to input their name for the player.
        System.out.println("What is player 2's name?: ");
        String p2Name = sc.nextLine();
        Player p2 = new Player(p2Name);
        //DONE: Create Player 2

        String again = "Literally any string";
        Player currentPlayer;
        
        //Runs the game
        while (!again.equals("q")){
            //Generates the game
            Game game = new Game(p1, p2);
            //DONE: Create "game"


            //DONE: Set a random player as the current player
            if (Math.random()*0.5 <= 0.5) {
                currentPlayer = p1;
            } else {
                currentPlayer = p2;
            }

            game.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!game.isComplete()){
               //DONE
               game.takePiece();
                
               currentPlayer = game.getNextPlayer();

               if (currentPlayer == p1) {
                game.turn = false;
               } else {
                game.turn = true;
               }
               
            }
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
