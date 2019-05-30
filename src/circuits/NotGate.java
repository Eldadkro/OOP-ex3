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
		Gate g = inGates[0].simplify();
		if(g instanceof FalseGate)
			return TrueGate.instance();
		if(g instanceof TrueGate)
			return FalseGate.instance();
		if(g instanceof NotGate)
			return g.simplify();
		return this;
	}

}
