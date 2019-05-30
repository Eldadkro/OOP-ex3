package images;

public abstract class ImageDecorator implements Image {

	protected Image base; // the base image we cover
	
	public ImageDecorator(Image base) {
		this.base = base;
	}
	
	@Override
	public int getWidth() {
		return base.getWidth();
	}

	@Override
	public int getHeight() {
		return base.getHeight();
	}
	
	

}
