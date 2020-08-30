/**
 * JavaCalculations, train your mind
 * @author OrangoMango
 * @version 2.0
 */
package com.orangomango.javacalc;

import java.io.*;
import java.util.Random;

class Exercise{
  private int a;
  private int b;
  private char operator;
  private int of;
  public Random rnd = new Random();
  private int correct;
  public static final char[] OPERATORS = new char[]{'+', '-', '*', '/'};
  public int number;
  
  /**
   * Exercise class constructor
   * @param number - number of current exercise, max - number of exercises
   */
  public Exercise(int number, int max){
    this.number = number;
    this.of = max;
    this.setNumbers();
  }
  
  /**
   * @return a random operator between [+, -, *, /]
   */
  private char getOperator(){
    int r = this.rnd.nextInt(4);
    return Exercise.OPERATORS[r];
  }
  
  /**
   * @return the exercise as a <code>String</code>
   */
  @Override
  public String toString(){
    return "Exercise "+this.number+" of "+this.of+". "+this.a+" "+this.operator+" "+this.b+" = ?";
  }
  
  /**
   * @return a random number between 1 and 20
   */  
  private int getNumber(){
    int r = this.rnd.nextInt(19)+1;
    return r;
  }
  
  /**
   * Checks answer provided from user
   * @return <code>true</code> if the answer is correct otherwise <code>false</code>
   */  
  public boolean checkAnswer() throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter answer: ");
    try {
      int answer = Integer.parseInt(reader.readLine());
      return answer == correct;
    } catch (Exception e){
      return false;
    }
  }
  
  /**
   * @return correct answer
   */
  public int getCorrect(){
    return this.correct;
  }
  
  /**
   * initialization of variables a, b and correct.
   * @throws IllegalArgumentException operator is unavailable
   */  
  private void setNumbers(){
    this.operator = this.getOperator();
    
    switch (operator){
      case '+':
        this.a = this.getNumber();
        this.b = this.getNumber();
        this.correct = this.a + this.b;
        break;
      case '-':
        this.a = this.getNumber();
        this.b = this.getNumber();
        this.correct = this.a - this.b;
        break;
      case '*':
        this.a = this.getNumber();
        this.b = this.getNumber();
        this.correct = this.a * this.b;
        break;
      case '/':
        this.correct = this.getNumber();
        this.b = this.getNumber();
        this.a = this.b * this.correct;
        break;
      default:
        throw new IllegalArgumentException("No operand available");
    }
  }
}

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
