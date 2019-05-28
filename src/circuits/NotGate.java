package circuits;

public class NotGate extends Gate {

	// Constructor
	public NotGate(Gate gate) {
		super(new Gate[1]);
		inGates[0] = gate;
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// returns not of the input of one
		try {
			return !(inValues[0]);
		} catch (Exception e) {
			throw new CircuitException();
		}
	}

	@Override
	public String getName() {
		//return "NOT"
		return "NOT";
	}

	@Override
	public Gate simplify() {
		// return the simplified version
		inGates[0] = inGates[0].simplify();
		if(inGates[0] instanceof FalseGate)
			return TrueGate.instance();
		if(inGates[0] instanceof TrueGate)
			return FalseGate.instance();
		if(inGates[0] instanceof NotGate)
			return inGates[0].inGates[0].simplify();
		return inGates[0];
	}

}
