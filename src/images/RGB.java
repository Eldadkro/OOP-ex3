package images;

public class RGB {

	private double r,g,b;
	
	public RGB(double grey) {
		this(grey,grey,grey);
	}
	
	private RGB(double a,double b,double c) {
		this.r = a > 1 ? 1 : a;
		this.g = b > 1 ? 1 : b;
		this.b = c > 1 ? 1 : c;
	}

	public double getRed() {
		return r;
	}

	
	public double getGreen() {
		return g;
	}


	public double getBlue() {
		return b;
	}

	public RGB invert() {
		return new RGB(1-r,g-1,b-1);
	}
	
	public RGB filter(RGB filter) {
		return new RGB(r*filter.r,g*filter.g,b*filter.b);
	}
	
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		return new RGB(rgb1.r +rgb2.r,rgb1.g +rgb2.g,rgb1.b +rgb2.b);
	}
	
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		RGB hue = new RGB(alpha);
		return superpose(rgb1.filter(hue), rgb2.filter(hue.invert()));
	}
	
	@Override
	public String toString() {
		return String.format("<%.3f, %.3f, %.3f>", r,g,b);
	}
	
	
	
	
}
