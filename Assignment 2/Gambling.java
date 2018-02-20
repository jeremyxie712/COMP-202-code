//student name: 
//student ID: 
//COMP202 2nd Assignment
public class Gambling{
  //This is the diceRoll method 
  public static int diceRoll(){
    //This is the program which takes random integer numbers ranging from 1 to 6
    int diceOne = (int)((Math.random() * 6) + 1);
    //This is the second dice also ranging integer numbers from 1 to 6
    int diceTwo = (int)(Math.random() * 6) + 1;
    //This is the sum of two dices ranging from 2 to 12
    int point = diceOne + diceTwo;
    //Returning the value of the sum of the two dices to the calling method.
    return point;
  }
  //This is the method of the secondStage, it will be initiated if necessary 
  public static int secondStage(int point){
    //Within this method, I decided to call the diceRoll first to roll a number first. And the diceRoll will assign the
    //new value to the new variable secondPoint
    int secondPoint = diceRoll();
    //After calling the diceRoll method, the method will compare the number from diceRoll to the requirements in the 
    //parameters of the while loop to see if it matches. Once it matches, it will enter the loop, vice versa. 
    while (secondPoint != 7 && secondPoint != point){
      //Printing the result of the while loop that are neither 7 nor previous point on a horizontal line.
      System.out.print(secondPoint + ", ");
      //Calling the method riceRoll again and looping them until it matches the requirment of the while loop.
      secondPoint = diceRoll();
    }
    //Printing out all the results from above and start a new line.
    System.out.print(secondPoint + "\n");
    //Returning the variable to the passLineBet method.
    return secondPoint;
  }
  //This is the method canPlay. Taking two double values as inputs.
  public static boolean canPlay(double moneyHas, double moneyBets){
    //Creating a new variable to test if the player has enought to bet or not.
    boolean canHeplay;
    //Setting up if statement to test if moneyHas is fewer than the money the player intends to bet.
    if (moneyHas < moneyBets){
      //when the money the player has is fewer than the money the player intends to bet, he cannot play, therefore
      //it returns as false.
      canHeplay = false;
    }
    //when he bets exactly the same amount he has or he has more money than he intends to bet, it will return true.
    else{
      canHeplay = true;
    }
    //Returning the boolean value to the method passLineBet.
    return canHeplay;
  }
  //This is the method passLineBet. It takes two double as inputs.
  public static double passLineBet(double totalMoney, double moneyToBet) {
    //It starts at calling the method canPlay to test if the player has enough money to bet or not.
    boolean canHePlay = canPlay(totalMoney, moneyToBet);
    //Setting up the variable point for later use.
    int point;
    //Flipping the statement requirement within the parentheses to prevent wrong assigning mistakes.
    //If canHePlay is false, then the player cannot play.
    if (false == canHePlay) {
      //Printing out the informing statement that the player is unable to participate in the passLineBet
      System.out.println("Insufficient funds. You cannot play.");
      //Return the money the player has at the moment to the main method.
      return totalMoney;
    } else {
      //When the player has enough money, the passLineBet method calls the diceRoll method to initiate the come-out Roll.
      point = diceRoll();
      //Determining if the player wins the game or not. If a 7 or a 11 comes out, the player wins the game.
      if (point == 7 || point == 11) {
        //Printing out the statement informing the victory of the participant.
        System.out.println("A " + point + " has been rolled." + " " + "You win");
        //At this moment, assigning the new value to totalMoney variable.
        totalMoney = totalMoney + moneyToBet;
        //Returning the variable to the main method.
        return totalMoney;
        //If the player rolls a 2 or a 3 or a 12, the player loses.
      } else if (point == 2 || point == 3 || point == 12) {
        //Printing a statement informing the loss of the player.
        System.out.println("A " + point + " has been rolled." + " " + "You lost.");
        //Assigning new value to the variable totalMoney.
        totalMoney = totalMoney - moneyToBet;
        //Returning the varibale to the main method.
        return totalMoney;
      } else {
        //Except the situation mentioned above, the player moves to the second round.
        System.out.println("A " + point + " has been rolled." + " " + "Roll again.");
        //Setting up a new variable store the returning point from the secondStage and
        //Calling the method secondStage
        int newPoint = secondStage(point);
        //Determining if the newPoint equals to 7, the player loses.
        if (newPoint == 7) {
          System.out.println("A " + newPoint + " has been rolled." + "You lost.");
          //Assigning new value to the variable totalMoeny.
          totalMoney = totalMoney - moneyToBet;
          //Returning the varibale to the main method.
          return totalMoney;
          //Another situation where the previous point was rolled up again. At this moment, the player wins the bet.
        } else if (point == newPoint) {
          //Printing statement informing the victory of the player.
          System.out.println("A " + newPoint + " has been rolled." + " " + "You win!");
          //Assigning new value to the variable.
          totalMoney = totalMoney + moneyToBet;
          //Returning the variable totalMoney to the main method.
          return totalMoney;
        }
        //This will not be executed, this is only for the use of successfully compiling the program.
        else{

          return totalMoney;
        }
      }
    }
  }
  //This is the main method.
  public static void main(String[] args){
    //Setting up variables totalMoney and moneyToBet
    double totalMoney = Double.parseDouble(args[0]);
    double moneyToBet = Double.parseDouble(args[1]);
    //Setting up a variable to store the value returned from the passLineBet method and calling the method.
    double finalMoney = passLineBet(totalMoney, moneyToBet);
    //Printing out the statement informing player's final funds' status. 
    System.out.println("You now have: " + finalMoney);
  }
}


    







