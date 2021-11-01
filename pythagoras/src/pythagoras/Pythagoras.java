package pythagoras;
import java.util.Scanner;

public class Pythagoras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String choice  = "";
		
		while(!choice.equals("L") || !choice.equals("H")) {
			System.out.println("Leg and leg (l) or hypotenuse and leg (h)?");
			choice = in.nextLine().toUpperCase();
			
			
		}
		

	}

}
