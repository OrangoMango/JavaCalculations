/**
 * JavaCalculations, train your mind
 * @author OrangoMango
 * @version 2.0
 */
package com.orangomango.javacalc;

import java.io.*;
import java.util.Random;

import com.orangomango.javacalc.Exercise;

public class JavaCalculations {

  public static int correct, wrong;
  
  /**
   * main method of program
   */
  public static void main(String[] args) throws IOException{
    long time1 = System.currentTimeMillis();
    
    for (int i=1;i<=10;i++){
      Exercise e = new Exercise(i, 10);
      System.out.println(e);
      boolean check = e.checkAnswer();
      System.out.println(check ? "====> Correct answer ("+(++correct)+")" : "====> Wrong answer ("+(++wrong)+"), correct -> "+e.getCorrect());
      System.out.println("---------------"); //Repeate string
    }
    
    long time2 = System.currentTimeMillis();
    float difference = (time2-time1)/1000F;
    
    System.out.println(String.format("Correct %d of %d, %d errors. Time: %.2fs", correct, 10, wrong, difference));
    
  }
}
