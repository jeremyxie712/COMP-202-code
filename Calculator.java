public class Calculator
{

 public static void main(String[] args)
 {
  System.out.println("Welcome to the Calculator program!");

  if (args.length < 3)
  {
   System.out.println("You need to enter three arguments to this program. Try typing 'run Calculator 5 5 1' in Dr. Java, or 'java Calculator 5 5 1 on the command line.");
   return;
  }

  int a = getIntegerNumber(args[0]);
  int b = getIntegerNumber(args[1]);
  float c = getFloatNumber(args[2]);

  System.out.println("The first argument is: " + a);
  System.out.println("The second argument is: " + b);
  System.out.println("The third argument is: " + c);

    //========================
    //Enter your code below

    //Student Name: 
    //Student Number: 
    
    //The sum of the a and b variables 
    int x = a + b;
    
    System.out.println("The sum of the a and b variables: " + x);
    
    //The product of the a and b variables 
    int h = a * b; 
    
    System.out.println("The product of the a and b variables: " + h);
    
    //The result of dividing a by b 
    int y = a / b; 
    
    System.out.println("The result of dividing a by b: " + y);
    
    //The result of dividing a by c
    float z = a / c; 
    
    System.out.println("The result of dividing a by c: " + z);
    
    //Testing whether a is larger than b 
    boolean isalargerthanb = a > b;
    
    System.out.println("Is a larger than b: " + isalargerthanb);
    
    //Testing whether a is an odder number 
    int remainder = a % 2;
    boolean isaodd = remainder == 1;
    System.out.println("Is a odd: " + isaodd);


    //Enter your code above
    //========================
 }

 public static int getIntegerNumber(String arg)
 {
  try
  {
   return Integer.parseInt(arg);
  }catch(NumberFormatException e)
  {
   System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
  }
             //error, return 1
  return 1;
 }

 public static float getFloatNumber(String arg)
 {
  try
  {
   return Float.parseFloat(arg);
  }catch(NumberFormatException e)
  {
   System.out.println("ERROR: " + e.getMessage() + " This argument must be a float!");
  }
             //error, return 1.0
  return 1.0f;
 }
}
