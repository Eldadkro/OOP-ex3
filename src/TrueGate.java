import circuits.CircuitException;
import circuits.Gate;

public class TrueGate extends Gate {

	private static TrueGate singleton = null;
	
	//this class is a singleton 
	//those the constructor is private
	private TrueGate(Gate[] inGates) {
		super(inGates);
		// Constructor
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// always returns true
		return true;
	}

	@Override
	public String getName() {
		// returns T as the name
		return "T";
	}

	@Override
	public Gate simplify() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//static method that return the single instance available 
	public static Gate instance() {
		if(singleton  == null)
			singleton = new TrueGate(null);
		return singleton;
	}

}
