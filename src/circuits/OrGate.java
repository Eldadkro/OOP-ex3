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
		Gate tmp;
		for (int i = 0; i < inGates.length && inGates[i] != null; i++) {
			tmp = inGates[i].simplify();
			if (tmp instanceof TrueGate)
				return TrueGate.instance();
			if (!(tmp instanceof TrueGate || tmp instanceof FalseGate))
				l.add(tmp);
		}
		if (l.size() == 0)
			return FalseGate.instance();
		if (l.size() == 1)
			return l.get(0);
		return new OrGate((Gate[]) l.toArray(new Gate[l.size()]));
	}

}
