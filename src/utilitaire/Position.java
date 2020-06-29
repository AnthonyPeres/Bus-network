package utilitaire;

public class Position {

	private double x;
	private double y;
	
	public Position(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	
	public double getPositionX() {
		return this.x;
	}
	
	public double getPositionY() {
		return this.y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
