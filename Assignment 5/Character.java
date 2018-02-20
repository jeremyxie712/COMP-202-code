    import java.util.Random;//import statements for using random class and ArrayList
    import java.util.ArrayList;
    public class Character{//Character class


      private String name;//Private attributes for name, attack value, max health, current health and win times.
      private double attVal;
      private double maxHelVal;
      private double currHelVal;
      private int numWins;
      private Random chaAttack = new Random();//private attributes for random class and ArrayList contains spell objects
      private static ArrayList<Spell> spells;

      public Character(String name, double attVal, double maxHelVal, int numWins){//Constructor
        this.name = name;
        this.attVal = attVal;
        this.maxHelVal = maxHelVal;
        currHelVal = maxHelVal;//Before the attack happens, the current health is the max health
        this.numWins = numWins;
      }
      public String getName(){//Getter for name
        return name;
      }
      public double getCurrHel(){//Getter for current health
        return currHelVal;
      }
      public double getMaxHel(){//Getter for max health level
        return maxHelVal;
      }
      public String toString(){//toString method, could also use as a debugger.
        String s = " ";
        s += "Name: " + this.name;
        s += " And its current health is: " + currHelVal;
        return s;
      }
      public double calcAttack(){//calcAttack method
        //The ranDamage method randomly generate a double num ranging between 0.3(inclusive) to 0.7(exclusive)
        double ranDamage = 0.3 + (chaAttack.nextDouble()*0.4);
        //And returning a number consisting of ranDamage times the Character's attack value
        return ranDamage*this.attVal;
      }
      public double getAttVal(){//Getter for attack value
        return attVal;
      }
      public void takeDamage(double attDamage){
        currHelVal = currHelVal - attDamage;//takeDamage method will use Character's currHealth minus the damage
      }
      public void increaseWins(){//Simply increase the wins by one
        numWins += 1;
      }
      public int getWins(){//Getter for win times
        return numWins;
      }
      public void printingInfo(){//Printing method that prints all the info of the Character out.
        System.out.println("Name: " + name + " Health: " + currHelVal + "\n" + "Attack: " + attVal + "\n" +
                           "Number of Wins: " + numWins);
      }
      public void setSpells(ArrayList<Spell> newSpellList){
        spells = newSpellList;//setSpells method that copies the parameter to the declared ArrayList spells
      }
      public double castSpell(String spellName){//castSpell method that takes a string as a variable
        double spellDamage = 0;//Declared and initialized a double named spellDamage
        Spell testSpell = null;//Declared and initialized a spell object names testSpell
        for(Spell s : spells){//foreach loop to iterate through the ArrayList
          String loop = s.getName().toLowerCase();

          if(loop.equals(spellName)){//If the ArrayList contains that spell, this spell is casted and call the getDamage
                                     //method to take damages.
            testSpell = s;
            spellDamage = s.getDamage();
            break;//break the loop
          }
        }
        if(testSpell != null){//If the testSpell is not null
          if(spellDamage <= 0){//When the spellDamage is lower or equal to 0, the player failed to cast the spell then
            System.out.println(this.name + " tried to cast the " + testSpell.getName() + ", but he failed." );
          }else{//Otherwise he managed to cast the spell
            String speDaTwoDecimal = String.format("%1$.2f", spellDamage);//Formatting for two decimal places
            //Player casted specific spell that cost how much damage, printing statement
            System.out.println(this.name + " casted " + testSpell.getName() + " for damage of " + speDaTwoDecimal);
          }
        }else{//Otherwise the spell wasn't recognized, then they won't be casted
          System.out.println(this.name + " tried to cast " + spellName + ", but they don't know that spell.");
        }
        //Return the damage caused by the spell 
        return spellDamage;
      }
    }