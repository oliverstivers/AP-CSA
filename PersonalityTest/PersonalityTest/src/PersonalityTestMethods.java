import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class PersonalityTestMethods{
    
    public static void nameAndAnswerArray(ArrayList<String> names, ArrayList<String> answer, File file){
        try{
           Scanner line = new Scanner(file); 
           int lineNumber = 1;
        while(line.hasNext()){
            if(lineNumber % 2 == 0){
                answer.add(line.nextLine());
                lineNumber++;
                
            }
            else if(lineNumber % 2 == 1){
                names.add(line.nextLine());
                lineNumber++;
                
            }
        }
        line.close();
        }
        catch(FileNotFoundException f){
        	System.out.println("file not found");
        }
        
        
    }
    public static ArrayList<String> getPersonality(String answer){
        int bCounter = 0;
        int aCounter = 0;
        double bPercent;
        ArrayList<String> personality = new ArrayList<>();
        //Introvert/Extrovert
        for(int i = 0; i < answer.length(); i+= 7){
            if(answer.substring(i, i + 1).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i, i + 1).toUpperCase().equals("A")){
                aCounter++;
                
                
            }
            else{}
        }
        System.out.println(aCounter + " " + bCounter);
        bPercent = bCounter / (double)((double)aCounter + (double)bCounter) * 100; 
        System.out.println(bPercent);
        
        if(bPercent == 50){
            personality.add("X");
        }
        else if(bPercent < 50){
            personality.add("E");
        }
        else if(bPercent > 50){
            personality.add("I");
        }
        
        bCounter = 0;
        aCounter = 0;
        //Sensation/intuition
        for(int i = 0; i < answer.length(); i+= 7){
            if(answer.substring(i, i + 1).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i, i + 1).toUpperCase().equals("A")){
                aCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("A")){
                aCounter++;
            }
        }
          bPercent = bCounter / (double)((double)aCounter + (double)bCounter) * 100; 
        if(bPercent == 50){
            personality.add("X");
        }
        else if(bPercent < 50){
            personality.add("S");
        }
        else if(bPercent > 50){
            personality.add("N");
        }
        bCounter = 0;
        aCounter = 0;
        //Thinking/feeling
        for(int i = 0; i < answer.length(); i+= 7){
            if(answer.substring(i, i + 1).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i, i + 1).toUpperCase().equals("A")){
                aCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("A")){
                aCounter++;
            }
        }
          bPercent = bCounter / (double)((double)aCounter + (double)bCounter) * 100; 
        if(bPercent == 50){
            personality.add("X");
        }
        else if(bPercent < 50){
            personality.add("T");
        }
        else if(bPercent > 50){
            personality.add("F");
        }
        bCounter = 0;
        aCounter = 0;

        //Judging vs perceiving
        for(int i = 0; i < answer.length(); i+= 7){
            if(answer.substring(i, i + 1).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("B")){
                bCounter++;
            }
            if(answer.substring(i, i + 1).toUpperCase().equals("A")){
                aCounter++;
            }
            if(answer.substring(i + 1, i + 2).toUpperCase().equals("A")){
                aCounter++;
            }
        }
          bPercent = bCounter / (double)((double)aCounter + (double)bCounter) * 100; 
        System.out.println(bPercent);
        if(bPercent == 50){
            personality.add("X");
        }
        else if(bPercent < 50){
            personality.add("J");
        }
        else if(bPercent > 50){
            personality.add("P");
        }
        bCounter = 0;
        aCounter = 0;

        return personality;
    }
    


}
