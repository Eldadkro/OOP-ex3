
package circuits;

public class VarGate extends Gate {

	private String name;
	private boolean value,flag;
	
	// Constructor
	public VarGate(String name) {
		super(new Gate[1]);
		this.name = name;
		
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		// return value else throws circuitException;
		if(!flag)
			throw new CircuitException();
		return value;
	}

	@Override
	public String getName() {
		// returns name
		return name;
	}

	@Override
	public Gate simplify() {
		// return true or false if a value has been fixed,otherwise return this
		return flag ? value ? TrueGate.instance() : FalseGate.instance() : this ;
	}
	
	public void setVal(boolean value) {
		flag = true;
		this.value = value;
	}

}
