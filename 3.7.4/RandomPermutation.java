import java.util.*;

public class RandomPermutation
{
  public static ArrayList<Horse> nextHorse(ArrayList<Horse> horses){
    ArrayList<Horse> old = horses;
    ArrayList<Horse> newHorse = new ArrayList<Horse>();

    while(old.size() > 0){ // while there are horses
        int spot = (int)(Math.random() * old.size());

        newHorse.add(old.remove(spot));
    } 
    return newHorse;
  } 
  
   public static int[] next(int length){
      int[] r = new int[length];
      int[] p = new int[length];
      
      for (int i = 0; i < length; i++)
        p[i] = i + 1;
        
      for (int n = length; n > 0; n--)
      {
        int pos = (int) (Math.random() * n);
        r[n-1] = p[pos];
        p[pos] = p[n-1];
      }
      
      // debug: System.out.println(java.util.Arrays.toString(r));
      return r;
   }
}