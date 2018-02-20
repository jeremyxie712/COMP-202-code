//Name: 
//McGill ID: 
//COMP202 Assignment 3 
import java.util.Arrays;//Import statement in order to use the Arrays.toString 
public class Cipher{ //Class Cipher
  /*public static void main(String[] args){ //Optional: main method
    System.out.println(charRightShift('g', 2));
    System.out.println(charLeftShift('#', 2));
    System.out.println(caesarEncode("cats and dogs", 5));
    System.out.println(caesarDecode("hfyx fsi itlx", 5));
    System.out.println(Arrays.toString(obtainKeys("hello")));
    System.out.println(vigenereEncode("elephants and hippos","rats"));
    System.out.println(vigenereDecode("vlxhyaglj tfu aagphk","rats"));
  }*/
  public static char charShift(char letter, int n){ //This is the aggregate charShift method, will be called later.
    char x = (char) ((int)letter+n);
    if(x > 'z'){ //If the character x, the sum of letter and n, is outside of the alphabet, we wrap around the alphabet. 
      x = (char)((int)x - 26);
    }
    else if(x <'a'){
      x = (char)((int)x + 26);
    }
    return x; //Returning char x to charRightShift or charLeftShift. 
  }
  public static char charRightShift(char rightLetter, int n){
    if(n < 0 || n > 25){ //Checking the n to see if it goes beyond the alphabet. 
      System.out.println("Error, integer n must be within the alphabet.");
      return ((char)0);//Returning ASCII Value of zero if n is negative or goes over 25. 
    }
    if(rightLetter < 'a' || rightLetter > 'z'){ //Returning the char itself if it's not in the lower case alphabet. 
      return rightLetter;
  }
  char receiverOne = charShift(rightLetter, n);//Calling the charShift method from here. 
  
  return receiverOne;//Returning receiverOne to caserEncode or vigenereEncode.  
  }
  public static char charLeftShift(char leftLetter, int n){
    if(n < 0 || n > 25){ //Checking the n must be in range. 
      System.out.println("Error, integer n must be within the alphabet");
      return ((char)0);
    }
    if(leftLetter < 'a' || leftLetter > 'z'){
      return leftLetter;
    }
    char receiverTwo = charShift(leftLetter, -n);//Negative n means the char in the alphabet shift leftwards. 
                                                 //Calling the method charShift again. 
    
    return receiverTwo;//Returning receiverTwo to caesarDecode or vigenereDecode. 
  }
  public static String caesarEncode(String message, int key){
    if(key > 26){ //Calculating the remainder. 
      key = key % 26;
    }else if(key < 0){
      key = (key % 26) + 26;
    }
    
    String encodedMessage = "";//Establishing an empty String first.
    int len = message.length();
    
    for(int i = 0; i< len; i++){//This is a loop that takes every letter of message out. 
      char testOne = message.charAt(i);
      encodedMessage = encodedMessage + charRightShift(testOne, key);//Pass the letters and int key to charRightShift
                                                             //And store the returning value into the empty string. 
    }
    return encodedMessage;//Now the ciphered word is stored in the string, return the string. 
  }
  public static String caesarDecode(String message, int key){
    if(key > 26){
      key = key % 26;
    }else if(key < 0){
      key = (key % 26) + 26;
    }
    
    String decodedMessage = "";//Estabishing an empty String first. 
    int length = message.length();
    
    for(int j = 0; j < length; j++){
      //Same intuition with the caesarEncode, taking every letter of message out and pass them with key to charLeftShift.
      char testTwo = message.charAt(j);
      decodedMessage = decodedMessage + charLeftShift(testTwo, key);//Store the returned value in the empty String. 
    }
    return decodedMessage;//Now the deciphered word is stored in the string, return the string. 
  }
  public static int[] obtainKeys(String target){
    int[] arr = new int[target.length()];//Creating a new array and it is the same size of the input String. 
    
    for (int i = 0; i < arr.length; i++){
      arr[i] = (char)target.charAt(i) - 'a';//Minus the lower case 'a' so we can get the position of the letter in the 
                                            //input message in the alphabet. Storing it in the array. 
    }
    return arr;//Returning the array that conatins the position # of the target. 
  }
  public static String vigenereEncode(String message, String keyword){
    String encryptedMessage = "";//Establishing an empty String first. 
    for(int i = 0; i < keyword.length(); i++){
      char lowerCaseEn = keyword.charAt(i); //We first write a loop to take every letter of keyword out to make sure 
                                            //it's a lower case letter. 
      if(lowerCaseEn < 'a' || lowerCaseEn > 'z'){
        //If any letter in the keyword is not a lowercase letter, print out an error message.
        System.out.println("Error, keyword is out of range.");
        return "";//Returning an empty string when letter is not a lowercase letter. 
      }
    }

    int[] keyNumbersEn = obtainKeys(keyword);//Calling the obtainKeys method and pass the keyword to the method. 
                                             //Storing the value obtained from the obtainKeys into a new array.               
    
    //Setting up a for loop with two looping variables in it. 
    for(int i = 0, j = 0 ; i < message.length(); i++, j = ++j % keyword.length()){
      char vigOne = message.charAt(i);//Take every letter out of the message. 
      int vigEn = keyNumbersEn[j];//Taking every single number inside the new array out. 
      encryptedMessage += (char)(charRightShift(vigOne, vigEn));//Calling the method charRightShift and pass the two 
                                                   //arguments. Storing the returned value in the empty String.
    }
    return encryptedMessage;//Now the String contains the ciphered word, return the string. 
  }
  public static String vigenereDecode(String message, String keyword){
    String decryptedMessage = "";//Establishing an empty String first 
    for(int i = 0; i < keyword.length(); i++){
      char lowerCaseDe = keyword.charAt(i);
      if(lowerCaseDe < 'a' || lowerCaseDe > 'z'){
        System.out.println("Error, keyword is out of range.");
        return "";//Same procedure to make sure keyword only contains lowercase letters, return empty string otherwise. 
      }
    }
    int[] keyNumbersDe = obtainKeys(keyword);//Calling the obtainKeys method and store the value into a new array. 
    
    for(int i = 0, j = 0; i < message.length(); i++, j = ++j % keyword.length()){
      char vigTwo = message.charAt(i);
      int vigDe = keyNumbersDe[j];
      decryptedMessage += (char)(charLeftShift(vigTwo, vigDe));//Passing the two variables to the charleftShift method. 

    }
    return decryptedMessage;//Now the string contains the deciphered word, return the string. 
  }
}



