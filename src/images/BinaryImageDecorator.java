package images;

public abstract class BinaryImageDecorator implements Image {

	
	protected Image i1,i2;
	
	public BinaryImageDecorator(Image i1,Image i2) {
		// Constructor
		this.i1 = i1;
		this.i2 = i2;
	}
	
	
	@Override
	public int getWidth() {
		
		return Math.max(i1.getWidth(), i2.getWidth());
	}

	@Override
	public int getHeight() {
		
		return Math.max(i1.getHeight(), i2.getHeight());
	}


}
