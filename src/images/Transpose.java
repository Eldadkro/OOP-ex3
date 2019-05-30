package images;

public class Transpose extends ImageDecorator {

	public Transpose(Image base) {
		super(base);
		// constructor
	}

	@Override
	public int getHeight() {
		return super.getWidth(); // flips the axis
	}

	@Override
	public int getWidth() {
		return super.getHeight(); // flips the axis
	}

	@Override
	public RGB get(int x, int y) {
		// gets the transposed pixel
		return base.get(y, x);
	}

}
