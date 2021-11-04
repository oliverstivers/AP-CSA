import java.util.Scanner;
//comment
//hello
public class CombinationLockTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CombinationLock combo = new CombinationLock("hell");
		System.out.println("Enter your guess: ");
        String guess = in.nextLine();
        System.out.println(combo.getClue(guess));
			while(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")) {
			System.out.println("Enter your guess: ");
			guess = in.nextLine();
            System.out.println(combo.getClue(guess));
			if(!(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")){
				break;
			}
			
		}
		System.out.println("Guess is correct!");
        in.close();
	}


}
