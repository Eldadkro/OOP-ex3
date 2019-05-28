package circuits;

public abstract class Gate {

	
	protected Gate[] inGates; // array of input modules 

	//Contractor
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}
	
	//a function that returns the value of the gate with 
	// inGates entrances 
	public boolean calc() throws CircuitException {
		if(inGates == null )
			return func(null);
		boolean[] results = new boolean[inGates.length];
		for(int i = 0;i < inGates.length && inGates[i] != null ;i++)
			results[i] = inGates[i].calc(); 
		return func(results);
	}

	//returns the value of the gate we are currently using
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	//returns the name of the gate
	public abstract String getName();
	
	//simplify the gate's output
	public abstract Gate simplify();

	//return a representation of the gate 
	// by using a stringBuilder and recursively printing each gates toString()
	public String toString() {
		if(inGates == null)
			return getName();
		if(inGates.length == 0 || inGates[0] == null)
			return getName();
		StringBuilder str = new StringBuilder();
		str.append(getName());
		str.append('[');
		for(int i=0;i<inGates.length && inGates[i] != null; i++) {
			str.append(inGates[i].toString());
			str.append(", ");
		}
		str.delete(str.length()-2, str.length());
		str.append(']');
		return str.toString();
	}

}
