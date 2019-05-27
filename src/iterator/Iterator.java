package iterator;

public interface Iterator {
	/*
	 * the interface gives us API for two methods hasnext : return true if it has
	 * next otherwise false next : returns the next element in the iterator
	 * 
	 */
	boolean hasNext();

	int next();

}
