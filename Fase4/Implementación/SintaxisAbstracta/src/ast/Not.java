package ast;

public class Not extends EUn {

	public Not(E opnd1) {
		super(opnd1);
	}

	@Override
	public TipoE tipo() {
		return TipoE.NOT;
	}
	
	@Override
	public String toString() {
		return "not{ " + opnd1.toString() + "}";
	}

}
