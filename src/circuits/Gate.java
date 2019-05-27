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
		boolean[] results = new boolean[inGates.length];
		int i = 0;
		for(Gate gate : inGates)
			results[i++] = gate.calc(); 
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
		if(inGates.length == 0)
			return getName();
		StringBuilder str = new StringBuilder();
		str.append(getName());
		str.append('[');
		for(Gate g :inGates) {
			str.append(g.toString());
			str.append(',');
		}
		str.deleteCharAt(str.length()-1);
		str.append(']');
		return str.toString();
	}

}
