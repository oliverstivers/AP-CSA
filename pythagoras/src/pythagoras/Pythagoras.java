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
			if(choice.equals("L")) {
				System.out.println("Enter the leg lengths");
				double length1 = in.nextDouble();
				double length2 = in.nextDouble();
				TriangleFinder hyp = new TriangleFinder(length1, length2);
				System.out.println("The hypotenuse is " + hyp.findHypotenuse());
				break;
			}
			else if(choice.equals("H")) {
				System.out.println("Enter the leg and hypotenuse");
				double length1 = in.nextDouble();
				double length2 = in.nextDouble();
				if(length1 > length2) {
					TriangleFinder leg = new TriangleFinder(length2, length1);
					System.out.println("The missing leg is " + leg.findLeg());
					break;
				}
				else if(length2 > length1) {
					TriangleFinder leg = new TriangleFinder(length1, length2);
					System.out.println("The missing leg is " + leg.findLeg());
					break;
				}
			}
			else {
				System.out.println("Symbol " + choice + " not recognized");
			}
			
		}
		

	}

}
