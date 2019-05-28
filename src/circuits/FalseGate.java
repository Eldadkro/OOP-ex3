package circuits;

public class FalseGate extends Gate {

	private static FalseGate singleton ;
	
	private FalseGate(Gate[] inGates) {
		super(inGates);
		// constructor
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// return false
		return false;
	}

	@Override
	public String getName() {
		// return "F"
		return "F";
	}

	@Override
	public Gate simplify() {
		return this;
	}
	
	//static method that return the single instance available 
	public static Gate instance() {
		if(singleton  == null)
			singleton = new FalseGate(null);
		return singleton;
	}


}
