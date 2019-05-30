package images;

public abstract class BaseImage implements Image {

	private int height, width;
	protected RGB[] colors = new RGB[2]; // define the colors of the image

	public BaseImage(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

}
