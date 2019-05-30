package images;

public class Mix extends BinaryImageDecorator {

	private double alpha;
	
	public Mix(Image i1, Image i2,double alpha) {
		super(i1, i2);
		this.alpha = alpha;
	}
	

	@Override
	public RGB get(int x, int y) {
		
		RGB pixel = new RGB(0);
		boolean image1,image2;
		image1 = (x<i1.getWidth() && y<i1.getHeight());
		image2 = (x<i2.getWidth() && y<i2.getHeight());
		if(!image1 && !image2)
			return pixel;
		if(!image1 && image2)
			return i2.get(x,y);
		if(image1 && !image2)
			return i1.get(x, y);
		return RGB.mix(i1.get(x, y), i2.get(x, y), alpha);
	}

}
