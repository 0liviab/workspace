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

  // initializes a bunch of stuff
  private String phrase = loadPhrase();
  private String guesses = "";
  private String fillGuess = getBlank(phrase);
  private Boolean playerTurn = true;
  private Boolean done = false;
  private String tempLetter = "";

  // replaces phrase's letters with underscores while keeping spaces
  public String getBlank(String phrase) {
    int numLetters = phrase.length();
    String blankPhrase = " ";

    // go through every letter and replace appropriately
    for (int i = 0; i < numLetters; i++) {
      if (phrase.charAt(i) == ' ') { // could also do with sustring .equals
        blankPhrase += " ";
      } else {
        blankPhrase += "_";
      }
    }
    return blankPhrase;
  }

  // prompts user for their guess letter and returns it as "letter"
  public String getLetter() {

    System.out.println("\nPlease input a guess:");
    Scanner sc = new Scanner(System.in);
    String letter = sc.nextLine().toLowerCase();
    guesses += letter;
    tempLetter = letter;
    return letter;
  }

  // checks if the phrase contains the guessed letter and replaces if correct
  public void checkGuesses(String letter) {
    fillGuess = "";

    // go through every letter and replaces appropriately
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
    // prints out the new phrase with their guess included
    System.out.println(fillGuess);
  }

  // checks if their are still underscores
  // if underscores - game isn't done b/c phrase isn't completely guessed
  // if not underscores - game is done b/c phrase has been guessed
  public void checkForBlank() {
    checkGuesses(" ");

    if (fillGuess.contains("_")) {
      done = false;
      checkGuesses(getLetter());
    } else {
      done = true;
    }
  }

  // returns game status
  // if "done" is true - game is over
  // if "done" is false - game continues
  public Boolean getStatus() {
    return done;
  }

  // player one's turn
  public void playerOneTurn() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Oops, something went wrong! Restart the game");
      ;
    }
    Helper.clearScreen();

    // announces player turn
    System.out.println("PLAYER ONE'S TURN: \n");

    // playerTurn, boolean announces whose turn it is
    // if playerTurn is true - player one's turn
    // if playerTurn is false - player two's turn

    // prints out the current phrase with any accurate guesses included
    checkGuesses(" ");
    // print out previous guesses
    System.out.println("guesses: \n" + guesses);

    while (playerTurn) {

      // if game isn't done, prompt player one for a guess, check if it's in phrase
      // and replace if needed

      if (fillGuess.contains("_")) {
        checkGuesses(getLetter());
        System.out.println("guesses: \n" + guesses);

          if (Character.isLetter(tempLetter.charAt(0))) {
            if (tempLetter.length() == 1) {

              if (fillGuess.contains(tempLetter)) {

                System.out.println(tempLetter + " is in the phrase!");

              } else {

                System.out.println(tempLetter + " is NOT in the phrase!");
                System.out.println("Your turn is over...");
                playerTurn = false;

              }

            } else {

              System.out.println("Your guess wasn't a single letter, so you sacrificed your turn");
              break;
            }
          } else {

            System.out.println("Your guess wasn't a letter, so you sacrificed your turn");
            break;
          }
        
        } else {
          done =true;
          break;
        }
    }
  }

  // same comments as playerOneTurn()
  public void playerTwoTurn() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println("Oops, something went wrong! Restart the game");
      ;
    }
    Helper.clearScreen();

    System.out.println("PLAYER TWO'S TURN: \n");

    checkGuesses(" ");
    System.out.println("guesses: \n" + guesses);

    while (!playerTurn) {
      if (fillGuess.contains("_")) {

        checkGuesses(getLetter());
        System.out.println("guesses: \n" + guesses);

          if (Character.isLetter(tempLetter.charAt(0))) {

            if (tempLetter.length() == 1) {

              if (fillGuess.contains(tempLetter)) {

                System.out.println(tempLetter + " is in the phrase!");

              } else {

                System.out.println(tempLetter + " is NOT in the phrase!");
                System.out.println("Your turn is over...");
                playerTurn = true;

              }
            } else {

              System.out.println("Your guess wasn't a single letter, so you sacrificed your turn");
              break;

            }
          } else {

            System.out.println("Your guess wasn't a letter, so you sacrificed your turn");
            break;

          }

      } else {

        done = true;
        break;

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