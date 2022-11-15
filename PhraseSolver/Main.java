package PhraseSolver;

public class Main {

    public static void main(String[] args){
        Player p1 = new Player();
        Player p2 = new Player();
        Board board = new Board();
        //helper help = new helper();

        System.out.println("\n\nWelcome " + p1.getName1() + " and " + p2.getName2() + "!");
        System.out.println("\nA random phrase is below. Try to guess it!");
    
        while (!board.getStatus()) {
            //helper.clearScreen();
            board.playerOneTurn(); 
            board.playerTwoTurn();
        }
        
        System.out.println("You won the game! Congrats");
       

        }


        
}

