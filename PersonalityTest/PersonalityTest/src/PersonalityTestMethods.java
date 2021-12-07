import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class PersonalityTestMethods{
    
    public static void nameAndAnswerArray(ArrayList<String> names, ArrayList<String> answers, File file){
        try{
           Scanner line = new Scanner(file); 
           int lineNumber = 1;
        while(line.hasNext()){
            if(lineNumber % 2 == 0){
                answers.add(line.nextLine());
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

        }
        
        
    }
}
