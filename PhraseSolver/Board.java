package PhraseSolver;

import java.util.Scanner;
import java.io.File;

public class Board {
  /*
   * print out phrase with blanks
   * as letters are guessed, print out the guesses
   * when guess = correct, update and get rid of underscore
   * use word.contains("Y"); to use boolean
   */

  private String phrase = loadPhrase();
  private String guesses = "";
  private String fillGuess = getBlank(phrase);
  private String letter = getLetter();

  
  public String getBlank(String phrase) {
    int numLetters = phrase.length();
    String blankPhrase = " ";
    for (int i = 0; i < numLetters; i++) {
      if (phrase.charAt(i) == ' ') { // could also do with sustring .equals
        blankPhrase += " ";
      } else {
        blankPhrase += "_";
      }
    }
    return blankPhrase;
  }

  public String getLetter() {
  System.out.println("\nPlease input a guess:");
  Scanner sc = new Scanner(System.in);
  String letter = sc.nextLine();
  guesses += letter;
  return letter;
  } 

  public void checkGuesses(String letter) {
    fillGuess = "";
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.substring(i, i+1).equals(" ")) {
        fillGuess += " ";
      } else if (phrase.substring(i, i + 1).equals(letter)) {
        fillGuess += letter;
      } else if (guesses.contains(phrase.substring(i, i+1))) {
        fillGuess += phrase.substring(i, i+1);
      } else {
        fillGuess += "_";
      }
    }
    System.out.println(fillGuess);
    System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);
  }

  public void checkForBlank() {
    checkGuesses(" ");

    while (fillGuess.contains("_")) {
      checkGuesses(getLetter());
    }
  }

  public void playerOneTurn(){
    checkForBlank();
    if (phrase.contains(getLetter())){
      System.out.println(letter + " is in the phrase!");
      checkForBlank();
    } else {
      System.out.println(letter + "is NOT in the phrase!");
      playerTwoTurn();
    }
  }

  public void playerTwoTurn(){
    checkForBlank();
    if (phrase.contains(getLetter())){
      System.out.println(letter + " is in the phrase!");
      checkForBlank();
    } else {
      System.out.println(letter + "is NOT in the phrase!");
      playerOneTurn();
    }
  }


  // returns random phrase from phrases.txt
  private String loadPhrase() {
    String tempPhrase = "";

    int numOfLines = 0;
    tempPhrase = "how are you";

    try {

      Scanner sc = new Scanner(new File(/* Replace with the path */"/workspace/workspace/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine()) {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }

    int randomInt = (int) ((Math.random() * numOfLines) + 1);

    try {
      int count = 0;
      Scanner sc = new Scanner(new File(/* Replace with the path */"/workspace/workspace/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine()) {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt) {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) {
      System.out.println("Error reading or parsing phrases.txt");
    }
    return tempPhrase;

  }
}