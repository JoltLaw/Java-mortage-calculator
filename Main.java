

import java.awt.*;
import java.lang.reflect.Array;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
  
  
  
  public static void main(String[] args) {
    Boolean isEligable = eligible(args);
    if(isEligable){
      System.out.println("Eligable for a loan");
      mortgageCalculations(args);
      } else {
        System.out.println("Not eligable for a loan");
      }
  } 

  public static boolean eligible(String[] args) {
    Scanner scanner = new Scanner(System.in);

    
    
    System.out.print("Income: ");
    int income = scanner.nextInt();
    boolean hasHighIncome = (income > 100_000);
   

    System.out.print("Good credit: ");
    boolean hasGoodCredit = scanner.nextBoolean();
    if (hasHighIncome || hasGoodCredit) {
      return true;
    } else {
      return false;
    }
  }

  public static void mortgageCalculations(String[] args) {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Principal($1k - $1M): ");
    int principal = scanner.nextInt();
    boolean validPrinciple = principal > 1_000 && principal <= 1_000_000;

      while (!validPrinciple){
        System.out.println("Enter a number between 1,000 and 1,000,000.");
        System.out.print("Principal($1k - $1M): ");
        principal = scanner.nextInt();
        validPrinciple = principal > 1_000 && principal <= 1_000_000;
      }

      System.out.print("Annual Interest Rate: ");
      float annualInterest = scanner.nextFloat();
      boolean validAnnualInterest = annualInterest > 0 && annualInterest <= 30;

      while (!validAnnualInterest) {
        System.out.println("Enter a value greater than 0 and less than or equal to 30. ");
        System.out.print("Annual Interest Rate: ");
        annualInterest = scanner.nextFloat();
        validAnnualInterest = annualInterest > 0 && annualInterest <= 30;

      }

      float monthlyIntest = annualInterest / PERCENT /  MONTHS_IN_YEAR;

      System.out.print("Period (Years): ");
      byte years = scanner.nextByte();
      boolean validPeriod = years > 0 && years <= 30;
      
      while (!validPeriod) {
        System.out.println("Enter a value between 1 and 30");
        System.out.print("Period (Years): ");
        years = scanner.nextByte();
        validPeriod = years > 0 && years <= 30;
      }

      int numberOfPayments = years * MONTHS_IN_YEAR;

      double mortgage = principal * (monthlyIntest * Math.pow(1 + monthlyIntest, numberOfPayments)) / (Math.pow(1 + monthlyIntest, numberOfPayments) -1); 
    
      String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
      System.out.println("Mortgage: " + mortgageFormatted);
  }
}
