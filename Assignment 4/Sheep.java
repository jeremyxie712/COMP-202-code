//Name: 
//Student ID: 
//COMP202 Assignment 4
import java.util.Random;//Import statement for later use for Random class
public class Sheep{//Sheep class 
  
  //Private attributes of sheep's names, ages and if they have wools
  private String name;
  private int age;
  private boolean hasWool;
  static int seed = 123;
  private static Random numberGenerator = new Random(seed);//Declaring the random class and initializing it with the 
                                                           //seed at the same time. 
  
  public String getName(){//Getter for sheep names 
    return name;
  }
  public int getAge(){//Getter for sheep ages 
    return age;
  }
  public Sheep(String name, int age){//Constructor for sheep class 
    this.name = name;
    this.age = age;
    this.hasWool = true;
  }
  public double shear(){//Shear method
    if(this.hasWool){
      double woolPound = 6 + (numberGenerator.nextDouble()*5);//If the sheep has wool, we shear it and the woolPount is 
                                                              //a radnom number from 6 to 11, inclusive. 
      while(woolPound > 10){//If woolPound is more than 10 pounds, we do it again, so woolPound can only between 6 to 10, inclusive.
        woolPound = 6 + (numberGenerator.nextDouble()*5);
      }
      this.hasWool = false;//After shear the sheep, set hasWool to false as there are no wools left. 
      return woolPound;//Return the amount of wools we got. 
    }else{
      return 0;//If the sheep have no wool at all, return 0 as 0 pounds. 
    } 
  }
}