package images;

public class Superpose extends BinaryImageDecorator {

	public Superpose(Image i1, Image i2) {
		super(i1, i2);
	}

	@Override
	public RGB get(int x, int y) {
		RGB pixel = new RGB(0); // base color
		if(x<i1.getWidth() && y<i1.getHeight())
			pixel = RGB.superpose(pixel, i1.get(x, y)); // adds the first image
		if(x<i2.getWidth() && y<i2.getHeight())
			pixel = RGB.superpose(pixel, i2.get(x, y)); // adds the first image
		return pixel;
	}
	
	

}
