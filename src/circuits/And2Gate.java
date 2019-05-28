package circuits;

public class And2Gate extends AndGate {

	
	// Constructor
	public And2Gate(Gate g1,Gate g2) {
		super(new Gate[2]);
		inGates[0] = g1;
		inGates[1] = g2;
	}
	
	

}
