package Lavirint;

public class Polje {

	private int x;
	private int y;
	private int v;
	
	public Polje(int x, int y) {
		this(x, y, 0);
	}
	public Polje(int x, int y, int v) {
		super();
		this.x = x;
		this.y = y;
		this.v = v>0? v : 0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getV() {
		return v;
	}
	@Override
	public String toString() {
		return "--> (" + x + ", " + y + ") " + v + " <--";
	}
}
