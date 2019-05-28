package circuits;

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
		Gate[] array = new Gate[inGates.length];
		for(int i=0; i<inGates.length && inGates[i] != null; i++) {
			array[i] = inGates[i].simplify();
			if(array[i] instanceof TrueGate)
				return TrueGate.instance();
			if(!(array[i] instanceof TrueGate || array[i] instanceof FalseGate))
				l.add(array[i]);
		}
		if(l.size() == 0)
			return FalseGate.instance();
		if(l.size() == 1)
			return l.get(0);
		return new OrGate((Gate[]) l.toArray(new Gate[l.size()]));
	}

}
