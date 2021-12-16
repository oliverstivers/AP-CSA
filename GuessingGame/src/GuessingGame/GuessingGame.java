package src.GuessingGame;
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
	private static Scanner in = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
	
		
		
		String option = "Y";
		introduce();
		//while user keeps answering 'yes'
		while(option.toUpperCase().startsWith("Y")) {
			playOneGame();
			System.out.println("Would you like to play another game? (y or n) ");
			option = in.nextLine();
			// do {
				
			// } while (!in.hasNextLine());
			
				
		}
		printResults();
        in.close();
		
	}
	private static void introduce() {
		System.out.println("This program allows you to play a guessing game. \nI will think of a number between "
				+ MIN_NUMBER + " and " + MAX_NUMBER + " and will allow you to guess until you get it. \nFor each guess, I will tell you whether the right answer is higher or lower than your guess");
	}
	private static void playOneGame() {
		
		
	    guesses = 0;
	    //generates random number
	    int number = (int)(Math.random() * MAX_NUMBER + MIN_NUMBER);
	    System.out.println("I'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "...");
		System.out.println(number);
	    System.out.print("Your guess? ");
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
	    	System.out.print("Your guess? ");
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
		
		guessScanner.close();

	    
	}
	private static void printResults() {
		System.out.println("Overall results: ");
		System.out.println("total games = " + totalGames);
		System.out.println("total guesses = " + totalGuesses);
		System.out.println("guesses/game = " + (double)((double)totalGuesses / (double)totalGames ));
		System.out.println("Best game = " + bestGame);
	}
	private static void validInput(){
        
        while (!guessScanner.hasNextInt()) {
            System.out.println("Invalid data, try again");
            guessScanner.next();
        }
        guess = guessScanner.nextInt();
		
        
        
        
        
       
    }
	
	

}