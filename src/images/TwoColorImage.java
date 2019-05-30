package images;

public class TwoColorImage extends BaseImage {

	private TwoDFunc func;
	
	public TwoColorImage(int width, int height,RGB zero,RGB one,TwoDFunc func) {
		super(width, height);
		this.func = func;
		colors[0] = zero;
		colors[1] = one;
		
	}

	@Override
	public RGB get(int x, int y) {
		// this uses strategy in order to determine the color of the pixel
		double result = func.f(((double)x)/getWidth(), ((double)y)/getHeight());
		if(result < 0 )
			result = 0;
		if(result > 1)
			result = 1;
		return RGB.mix(colors[0], colors[1], 1-result); // as we decided when result is 1 we get color[0]
		
	}

}
