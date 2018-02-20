//Name:  
//Student ID: 
//COMP202 Assignment 4
public class Farm{
  
  //Private attributes 
  private Sheep[] sheepArray;
  private Dog dogNameFarm;
  private String name;
  
  public Farm(String name, Dog dogNameFarm, Sheep[] sheepIn){//Constructor for farm class. 
    this.name = name;
    this.dogNameFarm = dogNameFarm; 
    sheepArray = new Sheep[sheepIn.length];//Initializing the private sheepArray declared above.
    for(int i = 0; i < sheepIn.length; i++){
      sheepArray[i] = sheepIn[i];//Copying every element in the SheepIn array to sheepArray 
    }
    if(dogNameFarm.herd() < sheepIn.length){//Throwing an exception if the dog cannot herd this many sheep.
      String error = "Amount of sheep has gone beyond this breed of dog's capability."; 
      throw new IllegalArgumentException(error);
    }
  }
  
  public String getName(){//Getter for farm names
    return name;
  }
  
  public int getNumSheep(){//Getter for sheep amount
    return sheepArray.length;
  }
  
  public void printFarm(){//The printFarm method will print out the information about this farm 
    System.out.println(this.name);
    System.out.println(this.dogNameFarm.getName());//Calling the getter to get the dogs name. 
    System.out.println("Number of sheep: " + getNumSheep());
    //Calling the getter to get sheep's names and ages. 
    for(int i = 0; i < sheepArray.length; i++){
      System.out.print(sheepArray[i].getName());
      System.out.print(" " + sheepArray[i].getAge() + "\n");
    }
  }
  public double getWool(){//Getter to get wools 
    double woolAmount = 0.0;
    for(int i = 0; i < sheepArray.length; i++){
      woolAmount += sheepArray[i].shear();//Calling the shear method and adding all the wool amount together. 
    }
    return woolAmount;//Return the total wool we have now. 
  }
  
  
  
  
  
}