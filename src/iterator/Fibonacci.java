package iterator;

public class Fibonacci implements Iterator {

	private int limit;
	private int prev1 = 0, prev2 = 0;

	public Fibonacci(int upperBound) {
		// creates a new fibonacci iterator with an upper bound
		limit = upperBound;
	}

	@Override
	public boolean hasNext() {
		// TODO returns if their is more numbers till we reach the upper limit
		return prev1 + prev2 < limit;
	}

	@Override
	public int next() {
		// return the next fibunacci number in the sequence
		if (hasNext()) {
			int result = (prev1 + prev2) == 0 ? 1 : prev1 + prev2;
			prev1 = prev2;
			prev2 = result;
			return result;
		}
		return prev2;
	}

}
