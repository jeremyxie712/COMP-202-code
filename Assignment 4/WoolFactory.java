import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
  //The provided code generates random ages for sheep, and picks random names from the below array
  //You can modify this list of names as you wish (add/remove/replace elements).
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
    "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
    "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
    "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
    "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
    "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
    "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
    "George VI","Elizabeth II"};
  private static Random r = new Random(123);
  
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  
  public static void main(String[] args){
    //Student Name:
    //Student Number:
    //Your code goes here.
    Scanner sc = new Scanner(System.in);//Declaring a scanner object. 
    System.out.print("What is the name of your farm ?");
    String farmName = sc.nextLine();//This is to scane the next Line of the string of the name of the farm. 
    System.out.print("What is the name of your dog ?");
    String dogName = sc.nextLine();
    System.out.print("What kind of dog is " + dogName + " ?");
    String dogBreed = sc.nextLine();
    System.out.print("And how many sheep do you have ?");
    int sheepAmount = sc.nextInt();//Getting the amount of the sheeps. 
    System.out.println("The farm has " + sheepAmount + " sheep.");
    System.out.println("Farm : " + farmName + " Dog : " + dogName);  
    
    Sheep[] newSheepArray = new Sheep[sheepAmount];//Declaring and initializing the newSheepArray
    double totalWoolAmount = 0;//Declaring the initializing the total Wool amount we have. 
    for(int i = 0; i < sheepAmount; i++){
      String sheepName = getRandomName();//Calling the two method above to assign random names and ages to the sheep. 
      int sheepAge = getRandomAge();
      newSheepArray[i] = new Sheep(sheepName, sheepAge);//Calling sheep class to get put sheep name and age into the array.
      totalWoolAmount += newSheepArray[i].shear(); //Calling shear to shear the sheep. 
    }
    Dog newDogName = new Dog(dogName, dogBreed);//Calling the dog class
    
    Farm farm = new Farm(farmName, newDogName, newSheepArray);//Calling the farm class. 
    
    //print number of sheep and all other information by using the printFarm method in the farm class. 
    farm.printFarm();
    
    double woolMoney = totalWoolAmount * 1.45;//Each pound of wool is $1.45 and this get the amount of money got from wools.
    
    System.out.println("we just sheared " + totalWoolAmount + " of wool for a value of : " + woolMoney);//Printing out. 
    
    
  }
}
