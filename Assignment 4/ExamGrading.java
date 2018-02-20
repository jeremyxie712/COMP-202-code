//Name: 
//Student ID: 
//COMP202 Assignment 4
import java.util.Arrays; //Importing statement to print out arrays later 
public class ExamGrading{
  public static void main(String[] args){ //Main method
    char[][] a = {{'C','A','B','B','C','A'},{'A','A','B','B','B','B'}};
     char[] b = {'C','A','B','B','C','C'};
     System.out.println(Arrays.toString(gradeAllStudents(a,b)));
     
     char[] f = {'A','B','C','D','C','A'};
     char[] e = {'A','B','D','B','B','A'};
     char[] so = {'C','B','C','D','A','B'};
     System.out.println(numWrongSimilar(f,e,so));
     
     char[][] responses = {{'A','B','C','D','B','A'},{'C','B','D','D','B','B'},{'C','B','D','D','C','B'}};
     char[] solutions = {'C','B','C','B','A','A'};
     System.out.println(numMatches(responses, solutions, 1, 2));
     
     int flag = 1;
     char[][] temp1 = {{'C','A','B','B','C','A'},{'A','A','B','B','B','B'},{'C','B','A','B','C','A'},{'A','B','A','B','B','B'}};
     char[] solu = {'C','A','B','B','C','C'};
     System.out.println(Arrays.deepToString(findSimilarAnswers(flag, temp1, solu)));
    
  }
  public static double[] gradeAllStudents(char[][] responses, char[] solutions){ //Method gradeAllStudents
    double[] result = new double[responses.length];//Creating a new array that is the same length as responses
    for(int i = 0; i < responses.length; i++){
      double count = 0.0; //Creating a new double variable to contain points of students' answers. 
      char[] eachAnswer = responses[i];//Created a for loop to take each sub-Array out of the responses array and store
      //them inside of the new array eachAnswer 
      for(int j = 0; j < solutions.length;j++){//Another array to to take out each element inside the solutions. 
        if(eachAnswer.length != solutions.length){//If numbers of answers and numbers of solutions do not match, 
          //throw an IllegalArgumentException and return an error message.
          String errorMess = "Error. Student" + i + "'s responses do not match the solutions.";
          throw new IllegalArgumentException(errorMess);
        }
        if(eachAnswer[j] != solutions[j]){//Skipping the element that are not the same
          continue;
        }else if(eachAnswer[j] == solutions[j]){//If they are same, add one point to the count. 
          count += 1;
        }
      }
      result[i] = ((count/eachAnswer.length)*100);//Inputting each students' points into the result array,
                                                 //returning a number from 0 to 100. 
    }
    return result;//Return the result array. 
  }
  
  public static int numWrongSimilar(char[] studentOne, char[] studentTwo, char[] solutions){
    int sameWrongAnswers = 0;//Create a new variable to take number of same wrong answers students have. 
    if(studentOne.length != studentTwo.length || studentTwo.length != solutions.length || studentOne.length != 
       solutions.length){ //Making sure students' responses length is the same as solutions. 
      String errMess = "Students' answers do not match the length of the solutions. ";
      throw new IllegalArgumentException(errMess);//Throw an exception if they are not the same size. 
    }
    for(int i = 0; i < studentOne.length; i++){ //Now I created a for loop to take each stduent's answer out 
                                                //to compare. 
      char c1 = studentOne[i];
      char c2 = studentTwo[i];
      if(c1 == c2 && c1 != solutions[i]){//If each students' answers are the same and they are not the right answer
                                         //then add up the sameWrongAnswer by one. 
        sameWrongAnswers++;
      }
    }
    return sameWrongAnswers;//Return the number of same wrong answers students have. 
  }
  public static int numMatches(char[][] responses, char[] solutions, int studentIndex, int similarity){
    char[] testStudents = responses[studentIndex];//Created a new character array
    int students = 0;//Creating an integer as how many students have the same wrong answers over the similarity threshold.
    for(int i = 0; i < responses.length; i++){//Using a for loop to check students responses. 
      if(i == studentIndex){//The first students and looping variable i both starts from 0, continue. 
        continue;
      }
      //Calling the method numWrongSimilar and passing three variables to the method. 
      int wrAnswers = numWrongSimilar(testStudents, responses[i], solutions);
      if(wrAnswers >= similarity){//If the wrong Anwers is equal to or larger than the similarity threshold, then 
                                  //add up the students variable. 
        students++;
      }
    }
    return students;//Return the number of students who have same wrong answers over the similarity threshold. 
  }
  public static int[][] findSimilarAnswers(int flagAlert, char[][] responses, char[] solutions){
    int[][] simStudents = new int[responses.length][];//Creating and initializing a new two dimensional integer array 
                                                      //with the number of subarrays the same number of responses length. 
    for(int i = 0; i < responses.length; i++){
      //This for loop goes through simStudents's each subArray and initializing it by calling the numMatches method
      simStudents[i] = new int[numMatches(responses, solutions, i, flagAlert)];
      //Created a new varibale index.                                                                 
      int index = 0;
      for(int j = 0; j < responses.length; j++){//This for loop will go through each students' answers 
        if(j == i){//Making sure the for loop will continue becasue i and j both starts from 0. 
          continue;
        }
        //Declaring and initializing a new variable and called the numWrongSimilar method and passed three variables. 
        int stuWrSim = numWrongSimilar(responses[i], responses[j], solutions);
        if(stuWrSim >= flagAlert){//If stuWrSim is equal to or larger than the flagged Alert number, then the student 
                                  //who has the same wrong answers as the index students will be put into the simStudents
                                  //array at the corresponding position. 
          simStudents[i][index] = j;
          index++;//After that, the index increments by one. 
        }
      }
    }
    return simStudents;//Return the simStudents array. 
  }
  
}