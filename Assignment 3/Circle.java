//Name: 
//McGill ID: 
//COMP202 Assignment 3 
public class Circle{
  //My main method, creating three integers and one char and passed the four variables to drawCircle
  public static void main(String[] args){
    int radius = Integer.parseInt(args[0]);
    int a = Integer.parseInt(args[1]);
    int b = Integer.parseInt(args[2]);
    char c = args[3].charAt(0);
    //try and catch illegal argument exceptions when the verifyInput throw the exception out
      try{
    drawCircle(radius, a, b, c);
    }catch(IllegalArgumentException e){
      //Printing the error e out. 
      System.err.println(e);
    }
  }
  public static boolean onCircle(int radius, int a, int b, int x, int y){
    //Creating a new boolean variable result 
    boolean result; 
    int r = radius*radius;
    int distance = (x - a)*(x - a) + (y - b)*(y - b); //This is the centre of the circle function. 
    if (r <= distance && distance <= r+1){ 
      result = true;
    }
    else{
      result = false;
    }
    //Returning the result to the drawCircle method. 
    return result;   
  }
  public static void verifyInput(int radius, int a, int b){
    if (radius <= 0){ //If the radius is negative, crash the program and throw an exception argument 
      String errorMessageTwo = "Circle must have positive radius.";
      throw new IllegalArgumentException(errorMessageTwo);
    }
    if (a < radius || b < radius){ //integer a and b represent the coordinates of the centre of the circle
                                   //When they are smaller than the radius, the circle will be drawm outside of the
                                   //first quadrant. 
      String errorMessageOne = "Circle must fit in upper right quadrant.";
      throw new IllegalArgumentException(errorMessageOne);
    }
  }
  public static void drawCircle(int radius, int a, int b, char c){
    int verticalMinValue = 9;
    int horizontalMinValue = 9; //The minimum is a 9 by 9 Cartesian plane. 
    
    int verticalAxisLength = verticalMinValue;
    int horizontalAxisLength = horizontalMinValue;
    
    verifyInput(radius, a, b);
    if(a + radius + 1 > horizontalMinValue){ //Securing the circle with bigger radius could be drawn automatically in   
                                             //in the first quadrant. 
      horizontalAxisLength = a + radius + 1;
    }
    if(b + radius + 1 > verticalMinValue){ //Same above. 
      verticalAxisLength = b + radius + 1;
    }
    

    for (int y = verticalAxisLength + 1; y >= 0; y--){ //This is drawing the cartesian plane. 
      for (int x = 0; x <= horizontalAxisLength + 1; x++){
        if(onCircle(radius, a, b, x, y) == true){ //Calling onCircle in the drawCircle method, the onCircle method scans
                                                  //the first quadrant and if the dots are on circle, the method will
                                                  //draw them accordingly. 
          System.out.print(c);
        }
        else if(y == 0 && x == 0){
          System.out.print("+");
          continue;
        }
        else if(y == 0 && x == horizontalAxisLength + 1){ //Drawing hat for the horizontal axis. 
          System.out.print(">");
          continue;
        }
        else if(x == 0 && y == verticalAxisLength + 1){ //Drawing hat for the vertical axis. 
          System.out.print("^");
          continue;
        }
        else if(x == 0){
          System.out.print("|");
        }
        else if(y == 0){
          System.out.print("-");
        }
        else {
          System.out.print(" ");
        }
      }
      //Starting a new line. 
      System.out.println(); 
    }
  }
}



