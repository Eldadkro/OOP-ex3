package circuits;

import java.util.ArrayList;
import java.util.List;

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
		List<Gate> l = new ArrayList<Gate>();
		Gate[] array = new Gate[inGates.length];
		for(int i=0; i<inGates.length && inGates[i] != null; i++) {
			array[i] = inGates[i].simplify();
			if(array[i] instanceof FalseGate)
				return FalseGate.instance();
			if(!(array[i] instanceof TrueGate || array[i] instanceof FalseGate))
				l.add(array[i]);
		}
		if(l.size() == 0)
			return TrueGate.instance();
		if(l.size() == 1)
			return l.get(0);
		return new AndGate((Gate[]) l.toArray(new Gate[l.size()]));
	}
	

}
