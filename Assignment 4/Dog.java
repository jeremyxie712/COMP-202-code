//Name: 
//Student ID: 
//COMP202 Assignment 4
public class Dog{//Dog class
  
  //Two private attributes, dogs' names and breeds 
  private String name; 
  private String breed;
  
  public Dog(String name, String breed){//Constructor of dogs, taking inputs of names and breeds
    this.name = name;//Using this variable to connect the name and breed in this method to the private attributes
                     //declared above. 
    this.breed = breed;
  }
  public String getName(){//Getter, using to get the dogs' names 
    return name;
  }
  public int herd(){//The herd method making sure certain kind of dogs her certain amount of sheeps
    if(this.breed.toLowerCase().contains("collie")){
      return 20;
    }
    if(this.breed.toLowerCase().contains("shepherds")){
     return 25;
    }
    if(this.breed.toLowerCase().contains("kelpies")){
     return 30;
    }
    if(this.breed.toLowerCase().contains("teruvens")){
     return 30;
    }
    return 10;
  }
}