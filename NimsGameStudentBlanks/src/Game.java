import java.util.Scanner;
public class Game {
    private int pieces;
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);
    //private int x;
    public boolean turn;
    public int take;

    //Sets up the game with a random amount of pieces between 10 and 50
    //Sets up the players so they can be accessed
    public Game(Player p1, Player p2){
        pieces = (int) (Math.random() * 40 + 10);//DONE: Grab a random value between 10 and 50
        this.p1 = p1;
        this.p2 = p2;
    }

    //Allows a player to take a specific amount of pieces.
    //Adds the amount of pieces taken to the user's score.
    public int takePiece(){
        System.out.println("There are " + pieces + " remaining!");
        System.out.println("How many would " + currentPlayer.getName()+ " like to take?");
        take = Integer.parseInt(sc.nextLine());
       //DONE: Grab the user amount of pieces and repeat if it not allowed.
        while (!isLegal(take)){
            System.out.println("Try again. \n\nHow many would you like to take?");
            take = Integer.parseInt(sc.nextLine());
            isLegal(take);
        }
        //DONE: Adjust the pieces
        pieces = pieces - take;
        System.out.println("There are " + pieces + " remaining!");
        System.out.println("\n-----------------------\n");
        return take;
    }

    
    //**TO DO**//
    public Player getNextPlayer(){
        if (turn) {
            currentPlayer = p1;
        } else {
            currentPlayer = p2;
        }
    //Changes which players turn it is and returns the current player.
       
        return currentPlayer;
    }

    //Checks whether or not the user's requested move is allowed or not.
    public boolean isLegal(int x){
        boolean legal;
        if (x <= (pieces*.5) && x > 0 || x == 1){
            legal = true;
        } else  if (x <= 0){
            System.out.println("Your input was less than one, and is consequently invalid.");
            legal = false;
        } else {
            System.out.println("Your input was more than half of the pot, and is consquently invalid.");
            legal = false;
        }

        return legal;// Changed appropriately
    }


    //DO NOT CHANGE
    public boolean isComplete(){

        if (pieces == 0){ return true;}
        return false;
    }

    //DO NOT CHANGE
    public void setFirstPlayer(Player p){
        currentPlayer = p;
    }
}
