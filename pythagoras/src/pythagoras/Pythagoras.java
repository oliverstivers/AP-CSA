package pythagoras;
import java.util.Scanner;
public class Pythagoras {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String choice  = "";
		//hello there
		/**
		 * javadoc comment
		 */
		
		
		while(!(choice.equals("H") && choice.equals("L"))) {
			System.out.println("Would you like to enter two legs and find the hypotenuse (l), or enter a leg and a hypotenuse and find the other leg (h)?");
			choice = in.nextLine().toUpperCase();
			if(choice.equals("L")) {
				System.out.println("Enter the leg lengths");
				double length1 = in.nextDouble();
				double length2 = in.nextDouble();
				
				System.out.println("The hypotenuse is " + TriangleFinder.findHypotenuse(length1, length2));
				break;
			}
			else if(choice.equals("H")) {
				double length1 = 0;
				double length2 = 0;
				
				
				
				while(length1 == length2) {
					System.out.println("Enter the leg and hypotenuse");
					length1 = in.nextDouble();
					length2 = in.nextDouble();
					if(length1 > length2) {
						
						System.out.println("The missing leg is " + TriangleFinder.findLeg(length2, length1));
						break;
					}
					else if(length2 > length1) {
						
						System.out.println("The missing leg is " + TriangleFinder.findLeg(length1, length2));
						break;
					}
					System.out.println("Hypotenuse and leg cannot be equal, please try again:");
				}
				break;
			}
			else {
				System.out.println("Symbol " + choice + " not recognized, please try again: ");
			}
			
			
		}
		
		in.close();

	}

}
