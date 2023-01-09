import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    System.out.println("Randomized index list: ");
    RandomPermutation random = new RandomPermutation();
    int[] list = random.next(10);
    System.out.println(java.util.Arrays.toString(list));
    System.out.println(" \n\n");


    Horse Trigger = new Horse("Trigger", 1340);
    Horse Silver = new Horse("Silver", 1210);
    Horse Lady = new Horse("Lady", 1575);
    Horse Patches = new Horse("Patches", 1350);
    Horse Duke = new Horse("Duke", 1410);
    Horse Major = new Horse("Major", 1495);
    Horse Misty = new Horse("Misty", 1425);
    Horse Buddy = new Horse("Buddy", 1340);
    Horse Autumn = new Horse("Autumn", 1460);
    Horse Spirit = new Horse("Spirit", 1295);

    ArrayList<Horse> horses = new ArrayList<Horse>();
    horses.add(Trigger);
    horses.add(Silver);
    horses.add(Lady);
    horses.add(Patches);
    horses.add(Duke);
    horses.add(Major);
    horses.add(Misty);
    horses.add(Buddy);
    horses.add(Autumn);
    horses.add(Spirit);

    System.out.println("Original horse order: \n" + horses);

    RandomPermutation rand = new RandomPermutation();
    ArrayList<Horse> randHorses = rand.nextHorse(horses);
    System.out.println("\n\nRandomized horse order: \n" + randHorses);
    System.out.println(" ");
    int counter = 1;

    for(int x = 0; x < randHorses.size() - 1; x+=2){
    
        System.out.println("Pair " + counter + ": ");
        System.out.println(randHorses.get(x) + ", " + randHorses.get(x + 1));
        //randHorses.remove(x);
        System.out.println(" ");
    
      counter++;
    }

    if(randHorses.size() % 2 == 1){
      System.out.println("Unpaired horse: ");
      System.out.println(randHorses.get(randHorses.size() - 1));
    }
    else {
      System.out.println("All horses are paired.");
    }

  }
}