
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
    public static String getPersonality(String answer, ArrayList<Integer> percentList){
        int bCounter = 0;
        int aCounter = 0;
        double bPercent;
        String personality = "";
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
        
        bPercent = bCounter / (double)((double)aCounter + (double)bCounter) * 100; 
        percentList.add((int)(bPercent));
        
        if(bPercent == 50){
            personality +=("X");
        }
        else if(bPercent < 50){
            personality +=("E");
        }
        else if(bPercent > 50){
            personality +=("I");
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
        percentList.add((int)(bPercent));
        if(bPercent == 50){
            personality +=("X");
        }
        else if(bPercent < 50){
            personality +=("S");
        }
        else if(bPercent > 50){
            personality +=("N");
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
        percentList.add((int)(bPercent));
        if(bPercent == 50){
            personality +=("X");
        }
        else if(bPercent < 50){
            personality +=("T");
        }
        else if(bPercent > 50){
            personality +=("F");
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
        percentList.add((int)(bPercent));
        
        if(bPercent == 50){
            personality +=("X");
        }
        else if(bPercent < 50){
            personality +=("J");
        }
        else if(bPercent > 50){
            personality +=("P");
        }
        bCounter = 0;
        aCounter = 0;

        return personality;
    }
    public static void introduce(){
        System.out.println("This program processes a file of answers to the Keirsey Temperament Sorter. It converts the various A and B answers for each person into a sequence of B-percentages and then into a four-letter personality type.");
        System.out.println();
        
               
        
    }


}
