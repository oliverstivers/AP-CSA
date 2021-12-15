package src.GuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;
public class GuessingGame {
	//constants
	private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
	//stats
	private static int totalGames = 0;
	private static int totalGuesses = 0;
	private static int bestGame = Integer.MAX_VALUE;
    private static int guesses;
    
	private static int guess;
	private static Scanner guessScanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		String option = "Y";
		introduce();
		//while user keeps answering 'yes'
		while(option.toUpperCase().startsWith("Y")) {
			playOneGame();
			System.out.println("Would you like to play another game? (y or n) ");
			option = in.nextLine();
		}
		printResults();
        in.close();
		
	}
	private static void introduce() {
		System.out.println("This program allows you to play a guessing game. \nI will think of a number between "
				+ MIN_NUMBER + " and " + MAX_NUMBER + " and will allow you to guess until you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess");
	}
	private static void playOneGame() {
		
		Scanner in = new Scanner(System.in);
	    guesses = 0;
	    //generates random number
	    int number = (int)(Math.random() * MAX_NUMBER + MIN_NUMBER);
	    System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "...");
	    System.out.println("Your guess? ");
	    validInput();
	    guesses++;
		//while user guesses wrong
	    while(guess != number) {
	    	if(guess > number) {
	    		System.out.println("It's lower.");
	    		guesses++;
	    	}
	    	else if(guess < number) {
	    		System.out.println("It's higher.");
	    		guesses++;
	    	}
			//if guess = random number
	    	else {
	    		guess++;
	    		break;
	    		
	    	}
	    	System.out.println("Your guess?");
	    	validInput();	    	
	    }
	    if(guesses == 1) {
	    	System.out.println("You got it right in " + guesses + " guess");
	    }
	    else {
	    	System.out.println("You got it right in " + guesses + " guesses");
	    }
	    totalGuesses += guesses;
	    totalGames++;
	    if(guesses < bestGame) {
	    	bestGame = guesses;
	    }
		in.close();
	    
	}
	private static void printResults() {
		System.out.println("Overall results: ");
		System.out.println("total games = " + totalGames);
		System.out.println("total guesses = " + totalGuesses);
		System.out.println("guesses/game = " + (double)((double)totalGuesses / (double)totalGames ));
		System.out.println("Best game = " + bestGame);
	}
	private static void validInput(){
        
        try{
			//tries to set guess to nextInt
            guess = guessScanner.nextInt();  
        }
		//if user doesn't input int
        catch(InputMismatchException e){
            System.out.println("Invalid data type, please try again: ");
			guessScanner.next();
            validInput();
            
        }
		
        
        
        
        
       
    }
	
	

}