public class Player {
    private static int score = 0;
    private String name;

    //DO NOT CHANGE
    public Player(String name){

        this.name = name;
        System.out.println("\n-----------------------------\n");
    }

    //DONE
    public int/*Changed to appropriate data type, not void*/ getScore(){
        return score;
     
    }
    //DONE
    public String/*Changed to appropriate data type, not void*/ getName(){
        return name;
      
    }

    public static void adjustScore(int x){
        score +=x;
    }
}
