package PhraseSolver;

public class Main {

    public static void main(String[] args){
        Player p1 = new Player();
        Player p2 = new Player();
        Board board = new Board();
        helper help = new helper();

        //welcomes new player to game, introduces them
        System.out.println("\n\nWelcome " + p1.getName1() + " and " + p2.getName2() + "!");
        System.out.println("\nA random phrase is below. Try to guess it!");
    

        //while there are still underscores in the phrase (while the game is not done)
        while (!board.getStatus()) {
            
            
            //player one's turn until they guess incorrectly 
            board.playerOneTurn(); 

            //player two's turn until they guess incorrectly
            board.playerTwoTurn();
        }
        

        //once game is over, end program
        System.out.println(p1.returnName1() + " won the game! Congrats");
       

        }

/*
 * QUESTIONS:
 * How to have methods wait a few seconds before running? To let players read welcome message then clear screen (not immediately)
 */
        
}

