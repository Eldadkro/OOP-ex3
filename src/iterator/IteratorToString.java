package iterator;

public class IteratorToString {

	public static String toString(Iterator it) {
		// returns a string that represent all of an iterator's elements
		StringBuilder str = new StringBuilder(); // creates a string builder to build the string efficiently
		str.append('[');
		while (it.hasNext()) {
			str.append(it.next());
			str.append(' ');
		}
		str.deleteCharAt(str.length() - 1);
		str.append(']');
		return str.toString(); // returns the string representation
	}

}
