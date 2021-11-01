package pythagoras;

public class TriangleFinder {
	private double side1;
	private double side2;
	
	public TriangleFinder(double sideLength1, double sideLength2) {
		side1 = sideLength1;
		side2 = sideLength2;
		
	}
	public double findHypotenuse() {
		double hypotenuse = Math.sqrt((Math.pow(side1, 2) + Math.pow(side2, 2)));
		return hypotenuse;
	}
	public double findLeg() {
		double leg = Math.sqrt((Math.pow(side2, 2) - Math.pow(side1, 2)));
		return leg;
	}
	
}
