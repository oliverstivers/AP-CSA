import java.util.Scanner;
public class CombinationLockTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CombinationLock combo = new CombinationLock("hell");
		System.out.println("Enter your guess: ");
		String guess = in.nextLine();
		while(combo.getClue(guess).contains("*") || combo.getClue(guess).contains("+")) {
			System.out.println("Enter your guess: ");
			guess = in.nextLine();
			if(combo.)
		}
	}

}
