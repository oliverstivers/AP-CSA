import java.util.InputMismatchException;
import java.util.Scanner;
public class GuessingGame {
	public static int totalGames = 0;
	public static int totalGuesses = 0;
	public static final int minNumber = 1;
    public static final int maxNumber = 100;
	public static int bestGame = Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		String option = "Y";
		introduce();
		while(option.substring(0,1).toUpperCase().equals("Y")) {
			playOneGame();
			System.out.println("Would you like to play another game? (y or n) ");
			option = in.nextLine();
		}
		printResults();
        in.close();
		
	}
	public static void introduce() {
		System.out.println("This program allows you to play a guessing game. \nI will think of a number between "
				+ minNumber + " and " + maxNumber + " and will allow you to guess until you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess");
	}
	public static void playOneGame() {
		
		Scanner in = new Scanner(System.in);
	    int guesses = 0;
	    
	    int number = (int)(Math.random() * maxNumber + minNumber);
	    System.out.println("I'm thinking of a number between " + minNumber + " and " + maxNumber + "...");
        System.out.println(number);
	    System.out.println("Your guess? ");
	    int guess = validInput();
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
	    	guess = validInput();
	    	
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
	public static int validInput(){
        Scanner in = new Scanner(System.in);
        int input = 0;
        try{
            return in.nextInt();  
        }
        catch(InputMismatchException e){
            System.out.println("Invalid data type, please try again: ");
            validInput();
        }
        System.out.println(input);
        return input;
        
        
       
    }
	
	

}