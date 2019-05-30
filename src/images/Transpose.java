package images;

public class Transpose extends ImageDecorator {

	public Transpose(Image base) {
		super(base);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getHeight() {
		return super.getWidth();
	}
	
	@Override
	public int getWidth() {
		return super.getHeight();
	}
	
	@Override
	public RGB get(int x, int y) {
		// TODO Auto-generated method stub
		return base.get(y,x);
	}

}
