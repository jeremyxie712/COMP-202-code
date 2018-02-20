    import java.util.Random;//Import statements for using Random class
    public class Spell{


      //Private attributes for name, minDamage, maxDamage and chance of successfully throw the spell
      private String name;
      private double minDamage;
      private double maxDamage;
      private double succProb;
      private Random spellDamage = new Random();

      public Spell(String name, double minDamage, double maxDamage, double succProb){//Constructor
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.succProb = succProb;


        //If the min Damage is less than 0 OR min Damage is larger than the max Damage OR the chances of spell is
        //below 0 or above 1, throw an IllegalArgumentException and return an appropriate message
        if(minDamage < 0 || minDamage > maxDamage || succProb < 0 || succProb > 1){
          String error = "Error(s) has been found.";
          throw new IllegalArgumentException(error);
        }
      }
      public String getName(){//Getter for name
        return name;
      }
      public double getDamage(){//getDamage method that gets damage from spells casting
        double randNum = spellDamage.nextDouble();//Using random class and nextDoubel to generate a random double num.
        if(randNum > succProb){//If the randNum is over succProb, the damage is 0
          return 0;
        }else{//Otherwise return a damage that ranging between minDamage and maxDamage
          return (randNum*(maxDamage-minDamage)) + minDamage;
        }
      }
      public String toString(){//Using a toString method that return's the spellName, damage range and succProb.
        String s = " ";
        s += "Name: " + this.name;
        s += " Damege: " + minDamage + " -- " + maxDamage + " Chance: " + succProb*100 + "%";
        return s;
      }
    }