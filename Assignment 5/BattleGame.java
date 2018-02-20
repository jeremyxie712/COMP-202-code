    import java.util.Scanner;//Import statements for using scanner and ArrayList
    import java.util.ArrayList;
    public class BattleGame{

      //playGame method, returns nothing
      private void playGame(){
        //created two instances of Character, one is player, another one is monsther, noted as enemy.
        //Called the readCharacter method, from the FileIO class.
        Character player = FileIO.readCharacter("player.txt");
        Character enemy = FileIO.readCharacter("monster.txt");

        //Called printingInfo method in Character class.
        player.printingInfo();
        enemy.printingInfo();
        //Created a new ArrayList object that contains Spell objects, called readSpells method in FileIO class
        ArrayList<Spell> sList = FileIO.readSpells("spells.txt");
        for(Spell s : sList){//the loop will take out each element of the ArrayList
          System.out.println(s.toString());//Converting the element inside of the ArrayList to String variables.
        }
        //Called the setSpells method in Character class and pass along the ArrayList sList
        player.setSpells(sList);

        Scanner sc = new Scanner(System.in);//Created a scanner to take command from the user

        //This while loop will only be executed when player and enemy both are alive.
        while(player.getCurrHel() > 0 && enemy.getCurrHel() > 0){
          System.out.println("Enter a command: ");

          String firstCommand = sc.nextLine();//Using the scanner to take commands from the user
          //The firstCommand string will be trimmed regarding the spaces and will always change users'
          //input to lower case letters.
          firstCommand = firstCommand.trim().toLowerCase();


          if(firstCommand.equals("attack")){
            //Calling the doAttack method and pass along the player as first parameter and monster as second parameter
            doAttack(player, enemy);
            //if enemy's health is not above 0, enemy dies.
            if(enemy.getCurrHel() <= 0){
              //Call the increaseWins method to increase players' wins
              player.increaseWins();
              int playerWins = player.getWins();//Get players' wins times
              System.out.println(enemy.getName() + " was knocked out. " + player.getName() + " has won: " + playerWins +
                                 " times.");//Printing out the information how many times players win
              ////Writing players' wins to its file by accessing FileIO class and writeCharacter method
              FileIO.writeCharacter(player, "player.txt");
              break;//Break the loop, since the enemy already died
            }
            //Now call the doAttack second time but use monster as first parameter and player as second parameter
            doAttack(enemy, player);
            //If players' health is not above 0, player dies
            if(player.getCurrHel() <= 0){
              enemy.increaseWins();//Call the increaseWins method to icnrease enemys' win times
              int eneWins = enemy.getWins();//Get the number of wins of the enemy
              //Printing out the information the players has lost and how many times the enemy has won.
              System.out.println("Oh no! You lost!" + enemy.getName() + " has won: " + eneWins + " times.");
              //Writing to enemy's file for its win times by accessing the FileIO class and writeCharacter method.
              FileIO.writeCharacter(enemy, "monster.txt");
              break;
            }

          }
          else if(firstCommand.equals("quit")){//If the user quit, directly break the loop and print out a message.
            System.out.println("Goodbye!");
            break;
          }else{
              //If the user did not insert attack or quit, we assume its a spell and call the castSpell method
              //in the Character class.
            double speDamage = player.castSpell(firstCommand);
            enemy.takeDamage(speDamage);//Call the takeDamage method and enemy takes the damage
            String newSpeDamage = String.format("%1$.2f", speDamage);//Formatting it only has 2 decimal places
            if(speDamage > 0){
              //If successfully casted the spell, print out a message the enemy takes how much damage
              System.out.println(enemy.getName() + " takes " + newSpeDamage + " damage! ");
            }
            //If the nemy was dead because of the spell attack
            if(enemy.getCurrHel() <= 0){
              player.increaseWins();//Call the increaseWins method and increase players' wins
              int playerWins = player.getWins();//Get the win times of the players
              //print out the message how many times the player has won.
              System.out.println(enemy.getName() + " was knocked out. " + player.getName() + " has won: " + playerWins
                                   + " times.");
              //Write to the file of the enemy
              FileIO.writeCharacter(player, "player.txt");
              break;//break the loop
            }
            //Since only the player can cast spell, the enemy will fight back by using the doAttack method.
            doAttack(enemy, player);
            //The rest is exactly the same with the above.
            if(player.getCurrHel() <= 0){
              enemy.increaseWins();
              int eneWins = enemy.getWins();
              System.out.println("Oh no! You lost! " + enemy.getName() + " has won: " + eneWins + " times." );
              //Writing to monster's files by accessing the writeCharacter method in FileIO class
              FileIO.writeCharacter(enemy, "monster.txt");
              break;//break the loop
            }
          }
        }
      }
      //doAttack method that will take two Character objects as parameters
      private void doAttack(Character participantOne, Character participantTwo){
        //The first Character will generate a double number as its attacking damage by accessing the calcAttack method
        //in the Character class
        double partiOne = participantOne.calcAttack();
        String attackStr = String.format("%1$.2f", partiOne);//Formatting for 2 decimal places
        //Printing out that the first Character attacks for how much damage
        System.out.println(participantOne.getName() + " attacks for " + attackStr + " damage! ");
        participantTwo.takeDamage(partiOne);//The second Character takes damage

        if(participantTwo.getCurrHel() > 0){//If the second Character is still alive, print out how much health it left
          String remainHel = String.format("%1$.2f", participantTwo.getCurrHel());
          System.out.println(participantTwo.getName() + "'s current health is:  " + remainHel);
        }else{//Otherwise print out a statement stating the enemy is out.
          System.out.println(participantTwo.getName() + " was knocked out.");
        }
      }
      //Main method, only use to test the whole program.
      public static void main(String[] agrs){
        BattleGame testForFun = new BattleGame();
        testForFun.playGame();//Calling the playGame method to test it.
      }
    }

               