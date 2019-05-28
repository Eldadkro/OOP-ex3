package circuits;

import java.util.ArrayList;

public class AndGate extends Gate {

	public AndGate(Gate[] inGates) {
		super(inGates);
		// Constructor
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// return AND gate of all inputs
		try {
			boolean sum = true;
			for (boolean value : inValues)
				sum = sum && value;
			return sum;
		} catch (Exception e) {
			throw new CircuitException();
		}
	}

	@Override
	public String getName() {
		// return "AND"
		return "AND";
	}

	@Override
	public Gate simplify() {
		// return true , false or the problematic children
		ArrayList<Gate> l = new ArrayList<Gate>();
		for(int i=0; i<inGates.length && inGates[i] != null; i++) {
			inGates[i] = inGates[i].simplify();
			if(inGates[i] instanceof FalseGate)
				return FalseGate.instance();
			if(!(inGates[i] instanceof FalseGate || inGates[i] instanceof FalseGate))
				l.add(inGates[i]);
		}
		if(l.size() == 0)
			return TrueGate.instance();
		return new AndGate(l.toArray(null));
	}
	

}
