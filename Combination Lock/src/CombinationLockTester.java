import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CombinationLockTester 
{
	public static void main(String[] args) throws FileNotFoundException{s
        ArrayList<String> words = new ArrayList<String>();
        File f = new File("commonwords.txt");
        Scanner scF = new Scanner(f);
        while(scF.hasNext()){
            String line = scF.nextLine();
            Scanner scR = new Scanner(line);
            while(scR.hasNext()){
                String word1 = scR.next();
                words.add(word1);
            }
            scR.close();
        }
        String[] wordList = new String[words.size()];
        for(int i = 0; i < words.size(); i++){
            wordList[i] = words.get(i);
        }
        
		Scanner in = new Scanner(System.in);
        int guessCounter = 0;
        
		CombinationLock combo = new CombinationLock(wordList[WordGiver.giveRandom(wordList)]);
        
		System.out.println("Enter your guess, or type 'quit' to cancel: ");
        String guess = in.nextLine();
        guessCounter ++;
        while(guess.length() != 4 && !guess.equals("quit"))
        {
            System.out.println("Guess must be 4 letters, please try again: ");
            guess = in.nextLine();
        }
        
        if(!guess.equals("quit")){
        System.out.println(combo.getClue(guess));
        
			while(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+") && !guess.equals("quit"))
            {
			System.out.println("Guess is incorrect, please try again (quit to end): ");
			guess = in.nextLine();
            guessCounter++;
            while(guess.length() != 4 && !guess.equals("quit"))
            {
                System.out.println("Guess must be 4 letters, please try again: ");
                guess = in.nextLine();
                
            }
            if(!guess.equals("quit")){
            System.out.println(combo.getClue(guess));
            }
			else if(!(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")) || guess.equals("quit"))
            {
				guessCounter++;
                break;
                
			}			
		}
    }
		if(guess.equals("quit")){
            System.out.println("The word was " + combo.getCombo());
        }
        else{
            System.out.println("Good job! It took you " + guessCounter + " guesses.");
        }
        in.close();
        scF.close();
	}
}
