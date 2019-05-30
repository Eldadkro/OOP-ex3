package images;

public class Gradient extends BaseImage {


	public Gradient(int width, int height, RGB start, RGB end) {
		// Constructor
		super(width,height);
		colors[0] = start;
		colors[1] = end;
	}

	public RGB get(int x, int y) {
		return RGB.mix(colors[1],colors[0], ((double)x)/getWidth());
		//the alpha is the ratio between the x and the total picture 
	}
	
	
	
	
	
	

}
