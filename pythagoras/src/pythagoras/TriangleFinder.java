package pythagoras;

public class TriangleFinder {
	
	
	
	
	public static double findHypotenuse(double side1, double side2) {
		double hypotenuse = Math.sqrt((Math.pow(side1, 2) + Math.pow(side2, 2)));
		return hypotenuse;
	}
	public static double findLeg(double side1, double side2) {
		double leg = Math.sqrt((Math.pow(side2, 2) - Math.pow(side1, 2)));
		return leg;
	}
	
}
