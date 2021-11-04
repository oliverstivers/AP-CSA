import java.util.Scanner;

public class CombinationLockTester 
{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CombinationLock combo = new CombinationLock("hell");
		System.out.println("Enter your guess: ");
        String guess = in.nextLine();
        while(guess.length() != 4)
        {
            System.out.println("Guess needs to be 4 letters, please try again: ");
            guess = in.nextLine();
        }
        System.out.println(combo.getClue(guess));
			while(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")) 
            {
			System.out.println("Incorrect, try again: ");
			guess = in.nextLine();
            while(guess.length() != 4)
            {
                System.out.println("Guess needs to be 4 letters, please try again: ");
                guess = in.nextLine();
            }
            System.out.println(combo.getClue(guess));
			if(!(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")))
            {
				break;
			}
            
			
		}
		System.out.println("Guess is correct!");
        in.close();
	}


}
