import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  public static void main(String[] args){

    System.out.println("OG Review: " + textToString("/workspace/workspace/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println("NEW POSITIVE Review: " + fakePosReview("/workspace/workspace/ConsumerLab_Code/SimpleReview.txt"));
    System.out.println("NEW NEGATIVE Review: " + fakeNegReview("/workspace/workspace/ConsumerLab_Code/SimpleReview.txt"));


    //System.out.println("TOTAL OF REVIEW: " + totalSentiment("/workspace/workspace/ConsumerLab_Code/review.txt"));
    //System.out.println("STAR RATING: " + starRating("/workspace/workspace/ConsumerLab_Code/review.txt"));
  }

  
  public static String fakePosReview(String fileName) {
    String review = textToString(fileName); 
    review = removePunctuation(review);
    review += " ";
    int numWords = countWordsUsingSplit(review);
    String fakeReview = " ";

    for(int i = 0; i < numWords; i ++){
      String word = review.substring(0, review.indexOf(" "));

      if (word.substring(0, 1).equals("*")){
        fakeReview += " " + word.replace(review.substring(0, review.indexOf(" ")), randomPositiveAdj());
      } else {
        fakeReview += " " + word;
      }

      review = review.substring(review.indexOf(" ")+1);
    } 
      return fakeReview;
  }

  public static String fakeNegReview(String fileName) {
    String review = textToString(fileName); 
    review = removePunctuation(review);
    review += " ";
    int numWords = countWordsUsingSplit(review);
    String fakeReview = " ";

    for(int i = 0; i < numWords; i ++){
      String word = review.substring(0, review.indexOf(" "));

      if (word.substring(0, 1).equals("*")){
        fakeReview += " " + word.replace(review.substring(0, review.indexOf(" ")), randomNegativeAdj());
      } else {
        fakeReview += " " + word;
      }

      review = review.substring(review.indexOf(" ")+1);
    } 
      return fakeReview;
  }

  public static int starRating(String fileName){
      double totalVal = totalSentiment(fileName);
      int rating = 0;
      if (totalVal >= 10) { rating = 5;}
      else if (totalVal >= 5) { rating = 4; }
      else if (totalVal >= 2.5) { rating = 3; }
      else if (totalVal >= 0) { rating = 2; }
      else if (totalVal >= -0.5) { rating = 1; }
      else { rating = 0; }
      return rating;
  }

  public static double totalSentiment(String fileName){
    String review = textToString(fileName); 
    review = removePunctuation(review);
    review += " ";
    int numWords = countWordsUsingSplit(review);
    double total = 0;

    for(int i = 0; i < numWords; i ++){
      String word = review.substring(0, review.indexOf(" "));
      //System.out.println("Sentiment value of \"" + word + "\" is: " + thumb);
      total += sentimentVal(word);
      review = review.substring(review.indexOf(" ")+1);
    }
    
    return total;
  }

  public static int countWordsUsingSplit(String review){
    String[] words = review.split("\\s+");
    return words.length;
  }

  static{
    try {
      Scanner input = new Scanner(new File("/workspace/workspace/ConsumerLab_Code/cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/workspace/ConsumerLab_Code/positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("/workspace/workspace/ConsumerLab_Code/negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

      /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
 
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
}
