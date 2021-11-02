package pythagoras;

public class TriangleFinder {
	private double side1;
	private double side2;
	
	
	public TriangleFinder(double side1, double side2) {
		super();
		this.side1 = side1;
		this.side2 = side2;
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
