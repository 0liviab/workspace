package PhraseSolver;
import java.util.Scanner;
import java.io.File;
public class Board{
/* 
 * print out phrase with blanks
 * as letters are guessed, print out the guesses
 * when guess = correct, update and get rid of underscore
 * use word.contains("Y"); to use boolean
 */

 
 String phrase = loadPhrase();



public static String getBlank(String phrase){
  int numLetters = phrase.length();
  String blankPhrase = "";
  for (int i = 0; i <= numLetters; i++){
    if (phrase.charAt(i) == ' ') {
      blankPhrase += " ";
    }
    else {
      blankPhrase += "_";
    }

  }
return blankPhrase;
 }

  //returns random phrase from phrases.txt
private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try 
    {
      
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/workspace/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/workspace/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    return tempPhrase;

  }
}