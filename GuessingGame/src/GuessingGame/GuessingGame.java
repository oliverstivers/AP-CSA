package src.GuessingGame;

import java.util.InputMismatchException;
import java.util.Scanner;
public class GuessingGame {
	private static int totalGames = 0;
	private static int totalGuesses = 0;
	private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
	private static int bestGame = Integer.MAX_VALUE;
    private static int input = 0;
    private static int guess;
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		String option = "Y";
		introduce();
		while(option.substring(0,1).equalsIgnoreCase("Y")) {
			playOneGame();
			System.out.println("Would you like to play another game? (y or n) ");
			option = in.nextLine();
		}
		printResults();
        in.close();
		
	}
	public static void introduce() {
		System.out.println("This program allows you to play a guessing game. \nI will think of a number between "
				+ MIN_NUMBER + " and " + MAX_NUMBER + " and will allow you to guess until you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess");
	}
	public static void playOneGame() {
		
		Scanner in = new Scanner(System.in);
	    int guesses = 0;
	    
	    int number = (int)(Math.random() * MAX_NUMBER + MIN_NUMBER);
	    System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "...");
        System.out.println(number);
	    System.out.println("Your guess? ");
	    validInput();
        guess = input;
	    guesses++;
	    while(guess != number) {
	    	if(guess > number) {
	    		System.out.println("It's lower.");
	    		guesses++;
	    	}
	    	else if(guess < number) {
	    		System.out.println("It's higher.");
	    		guesses++;
	    	}
	    	else {
	    		guess++;
	    		break;
	    		
	    	}
	    	System.out.println("Your guess?");
	    	validInput();
            guess = input;
	    	
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
	public static void printResults() {
		System.out.println("Overall results: ");
		System.out.println("total games = " + totalGames);
		System.out.println("total guesses = " + totalGuesses);
		System.out.println("guesses/game = " + (double)((double)totalGuesses / (double)totalGames ));
		System.out.println("Best game = " + bestGame);
	}
	public static void validInput(){
        Scanner in = new Scanner(System.in);
        try{
            input = in.nextInt();  
        }
        catch(InputMismatchException e){
            System.out.println("Invalid data type, please try again: ");
            validInput();
            
        }
        
        
        
        
       
    }
	
	

}