package circuits;

import java.awt.List;
import java.util.ArrayList;

public class OrGate extends Gate {

	public OrGate(Gate[] inGates) {
		super(inGates);
		// Constructor

	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// return OR gate on all inputs
		boolean sum = false;
		try {
			for (boolean value : inValues)
				sum = sum || value;
			return sum;
		} catch (Exception e) {
			throw new CircuitException();
		}

	}

	@Override
	public String getName() {
		// returns OR
		return "OR";
	}

	@Override
	public Gate simplify() {
		// return true , false or the problematic children
		ArrayList<Gate> l = new ArrayList<Gate>();
		for(int i=0; i<inGates.length && inGates[i] != null; i++) {
			inGates[i] = inGates[i].simplify();
			if(inGates[i] instanceof TrueGate)
				return TrueGate.instance();
			if(!(inGates[i] instanceof TrueGate || inGates[i] instanceof FalseGate))
				l.add(inGates[i]);
		}
		if(l.size() == 0)
			return FalseGate.instance();
		return new OrGate(l.toArray(null));
	}

}
