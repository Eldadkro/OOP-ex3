package images;

import java.awt.Point;

public class Circle extends BaseImage {

	private Point centerP;
	private int radius;
	private RGB[] colors= new RGB[2];
	
	public Circle(int width, int height, int centerX, int centerY, int radius,RGB center, RGB outside) {
		super(width,height);
		centerP = new Point(centerX, centerY);
		this.radius = radius;
		colors[0] = center;
		colors[1] = outside;
	}
	
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size,size);
		centerP = new Point(size/2,size/2);
		this.radius = radius;
		colors[0] = center;
		colors[1] = outside;
	}
	

	@Override
	public RGB get(int x, int y) {
		// returns the correct color that the point should have
		double ratio = centerP.distance(x,y)/radius;
		return RGB.mix(colors[1], colors[0], ratio);
	}
	
}
