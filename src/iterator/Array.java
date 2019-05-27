package iterator;

public class Array implements Iterator {

	private int[] array;
	private int index = 0;

	public Array(int[] arr) {
		array = arr;
	}

	@Override
	public boolean hasNext() {
		// return true if has next element false otherwise
		return index < array.length;
	}

	@Override
	public int next() {
		// returns the current element of the array
		return array[index++];
	}

}
