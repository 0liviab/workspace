package PhraseSolver;

public class Main {

    public static void main(String[] args){
        Player p1 = new Player();
        Player p2 = new Player();
        Board board = new Board();

        p1.getName();
        p2.getName();

        System.out.println("Welcome " + p1.getName() + " and " + p2.getName() + "!  \n\n A random phrase is below. Try to guess it!");

        board.getBlank(board.phrase);


    }


}
