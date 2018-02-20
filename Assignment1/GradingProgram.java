public class GradingProgram{
  //This is the main method 
  public static void main(String[] args){
    
    //The three double variables here are assignment grades, midterm grades and final grades
    double assignment = Double.parseDouble(args[0]);
    double midterm = Double.parseDouble(args[1]);
    double finalExam = Double.parseDouble(args[2]);
    
    //Calling the void method printInput for basic entries and passing the three double varibles in the meantime
    printInput(assignment, midterm, finalExam);
    
    //Calling the finalGrade method to calculate which evaluation approach gives higher grades 
    finalGrade(assignment, midterm, finalExam);
    
  }
  
  //Method for confirming entries
  public static void printInput(double assignment, double midterm, double finalExam){
    //Printing out the entries
    System.out.println("You entered: " + assignment + " " + midterm + " " + finalExam);
  }
  
  //Divide method for further use
  public static double divide(double mark, int x){
    
    //Creating a variable to store result 
    double result;
    
    //Checking if the divisor is zero or not, the method will return zero if the divisor is zero and print out 
    //an appropriate error message 
    if (x == 0){
      result = 0;
      System.out.println("Error.");
      return result;
    }
    //Returning the value to the finalGrade method after being called 
    return mark / x;
    
  }
  //This is the getMax method to compare two numbers to decide whichever is larger 
  public static double getMax(double markOne, double markTwo){
    double max;
    //This is the if statement to determine which grades that were passed along offers higher grades 
    if (markOne > markTwo){
      max = markOne;
    } 
    //if mark one is smaller or equal to mark two, the method will return mark two 
    else{ 
      max = markTwo;
    }
    //Returning the value back to the finalGrade method 
    return max;
  }
  //The method calculating the students' final grades 
  public static double finalGrade(double assignment, double midterm, double finalExam){
    //Determining the range of the assignment grades 
    if (assignment > 35 || assignment < 0){
      System.out.println("Error: assignment grade is out of range.");
      
      //Returning the value to the main method when assignment grade is out of range. 
      return -1;
    }
    
    //Determining the range of the midterm grades 
    else if (midterm > 20 || midterm < 0){
      System.out.println("Error: midterm grade is out of range.");
      
      //Returning the value to the main method when midterm grade is out of range 
      return -1;
    }
    
    //Determining the range of the finalExam grades 
    else if (finalExam > 45 || finalExam < 0){
      System.out.println("Error: finalExam grade is out of range.");
      
      //Returning the value to the main method when finalExam is out of range 
      return -1;
    }
    
    //Creating a variable one to store the value returned by the divide method for further use. 
    double markPerOne;
    
    //Calling the divide method to calculate students' grades for evaluation approach one. 
    markPerOne = divide(assignment + midterm + finalExam, 100);
    
    //Creating the second variable to store the value returned by the divide method.
    double markPerTwo;
    //Calling the divide method to calculate students' grades for evaluation approach two.
    markPerTwo = divide(assignment + finalExam, 80);
    
    //Creating a variable to store the getMax value 
    double mark;
    
    //Calling the getMax method to compare the two grades and times 100 to return a value between 0 to 100
    mark = getMax(markPerOne, markPerTwo) * 100;
    
    //Printing out the final grade 
    System.out.println("Your final grade is: " + mark);
    
    //Returning the value back to the main method 
    return mark;
  }
}


  
    
    

    
                             