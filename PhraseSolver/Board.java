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
  private Boolean playerTurn = true;
  private Boolean done = false;
  private String tempLetter = "";

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
    tempLetter = letter;
    return letter;
  }

  public void checkGuesses(String letter) {
    fillGuess = "";
    for (int i = 0; i < phrase.length(); i++) {
      if (phrase.substring(i, i + 1).equals(" ")) {
        fillGuess += " ";
      } else if (phrase.substring(i, i + 1).equals(letter)) {
        fillGuess += letter;
      } else if (guesses.contains(phrase.substring(i, i + 1))) {
        fillGuess += phrase.substring(i, i + 1);
      } else {
        fillGuess += "_";
      }
    }
    System.out.println(fillGuess);
    // System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);
  }

  public void checkForBlank() {
    checkGuesses(" ");

    if (fillGuess.contains("_")) {
      done = false;
      checkGuesses(getLetter());
    } else {
      done = true;
    }
    // done = true;
  }

  public Boolean getStatus() {
    return done;
  }

  public void playerOneTurn() {
    System.out.println("PLAYER ONE'S TURN: \n");
    while (playerTurn) {
      checkGuesses(" ");
      System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

      if (fillGuess.contains("_")) {
        done = false;
        checkGuesses(getLetter());
        System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

      } else {
        done = true;
      }
      
      // checkForBlank();
      // returns once the phrase has no more underscores
      if (phrase.contains(tempLetter)) {
        System.out.println(tempLetter + " is in the phrase!");
        checkGuesses(" ");
        System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

        if (fillGuess.contains("_")) {
          done = false;
          checkGuesses(getLetter());
          System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

        } else {
          done = true;
        }
        // checkForBlank();
      } else {
        System.out.println(tempLetter + " is NOT in the phrase!");
        playerTurn = false;
      }
    }
  }

  public void playerTwoTurn() {
    System.out.println("PLAYER TWO'S TURN: \n");
    // System.out.println("p2a playerturn: " + playerTurn);

    while (!playerTurn) {
      // checkForBlank();
      checkGuesses(" ");
      System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

      if (fillGuess.contains("_")) {
        done = false;
        checkGuesses(getLetter());
        System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

      } else {
        done = true;
      }

      if (phrase.contains(tempLetter)) {
        System.out.println(tempLetter + " is in the phrase!");
        checkGuesses(" ");
        System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

        if (fillGuess.contains("_")) {
          done = false;
          checkGuesses(getLetter());
          System.out.println("\n\nYOUR GUESSES INCLUDE: \n" + guesses);

        } else {
          done = true;
        }
        // checkForBlank();
      } else {
        System.out.println(tempLetter + " is NOT in the phrase!");
        playerTurn = true;
      }
    }
  }

  // while game not done, while playerTurn = true, p1.getName(); & prompt
  // while game not done, check playerTurn, p1.getName() + " make a guess", ur
  // wrong playerTurn = false

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