    import java.io.*;//Import statements
    import java.util.ArrayList;
    public class FileIO{//FileIO class

      public static Character readCharacter(String filename){//readCharacter method that takes a String as an input
        Character participant;//Declaring a Character object
        try{
          //FileReader and BufferedReader for reading files like "player.txt" and "monster.txt"
          FileReader fr = new FileReader(filename);
          BufferedReader br = new BufferedReader(fr);

          //Declared and initialized a String variable that read each line
          String currentName = br.readLine();

          //Parsing the attack value and maximum health value using the Double.parseDouble()
          double currentAtt = Double.parseDouble(br.readLine());
          double currentMaxHel = Double.parseDouble(br.readLine());

          //Parsing the current win times using Integer.parseInt()
          int currentWins = Integer.parseInt(br.readLine());

          //Closing the BufferedReader and FileReader after finished reading
          br.close();
          fr.close();
          //Calling the Character class' constrcutor and passing four parameters
          participant = new Character(currentName, currentAtt, currentMaxHel, currentWins);

        }catch(FileNotFoundException e){//Catch block to throw an IllegalArgumentException in case files not found.
          String errMessOne = "File not found: " + filename;
          throw new IllegalArgumentException(errMessOne);//And return an appropriate error message
        }catch(IOException e){//Catch block to throw same exception in case IOException appears.
          String errMessTwo = "Error with the file: " + filename;
          throw new IllegalArgumentException(errMessTwo);
        }
        return participant;//Return the Character object, participant
      }

      //The readSpells method that takes a String as input and returns an ArrayList of Spell objects
      public static ArrayList<Spell> readSpells(String filename){
        ArrayList<Spell> sList = new ArrayList<Spell>();//Creating an instance of ArrayList sList

        try{
          //FileReader and BufferedReader to read info from "spell.txt"
          FileReader fr = new FileReader(filename);
          BufferedReader br = new BufferedReader(fr);

          //Declared a new String variable that read each line
          String lineInfo = br.readLine();
          while(lineInfo != null){//When the line is not null, the while loop executes

            //Using the space as a delimiter and using split method to put every variable into the String array tokens
            String[] tokens = lineInfo.split(" ");
            //Now the first variable in the tokens array is the name of the spell
            String spellName = tokens[0];
            //Second is the spell's minimum damage
            double minDamage = Double.parseDouble(tokens[1]);
            //Third is the spell's maximum damage
            double maxDamage = Double.parseDouble(tokens[2]);
            //Fourth is the spell's successful probabilities/ chances of making it
            double succProb = Double.parseDouble(tokens[3]);
            //Declaring a spell object s and call it's constructor and passing four parameters
            Spell s = new Spell(spellName, minDamage, maxDamage, succProb);
            sList.add(s);//Adding them to the ArrayList

            lineInfo = br.readLine();//Now, read a new line.

          }
          br.close();//After reading, close the BufferedReader and the FileReader
          fr.close();
        }catch(FileNotFoundException e){
          //Catch block to throw an IllegalArgumentException in case files not found.
          String errMessOne = "File not found: " + filename;
          throw new IllegalArgumentException(errMessOne);//And it returns an appropriate message
        }catch(IOException e){
          //Catch block to throw an IllegalArgumentException for IOExeption
          String errMessTwo = "Error with the file: " + filename;
          throw new IllegalArgumentException(errMessTwo);
        }
        return sList;//Return the ArrayList sList
      }

      //writeCharacter method that returns nothing, taking one Character object and one String as parameters.
      public static void writeCharacter(Character wriTarget, String filename){

        try{

          //FileWriter and BufferedWriter to write to the files.
          FileWriter fw = new FileWriter(filename);
          BufferedWriter bw = new BufferedWriter(fw);

          bw.write(wriTarget.getName());//Write the Character's name, using getter from Character class
          bw.write(System.lineSeparator());//Going to the next line
          bw.write(String.valueOf(wriTarget.getAttVal()));//Getter to write the AttValue
          bw.write(System.lineSeparator());//New Line
          bw.write(String.valueOf(wriTarget.getMaxHel()));//Getter to write the maximum health value
          bw.write(System.lineSeparator());
          bw.write(String.valueOf(wriTarget.getWins()));//Win times

          bw.close();//Closing the BufferedWriter and the FileWriter
          fw.close();
        }catch(IOException e){//Catch the IOExcepion and return an appropriate message.
          String errIOE = "Error.";
          throw new IllegalArgumentException(errIOE);
        }
      }
    }