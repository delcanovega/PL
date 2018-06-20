package ast;

public class NoEquiv extends EBin {

	public NoEquiv(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.NOEQUIV;
	}
	
	@Override
	public String toString() {
		return "noEquiv{ " + opnd1.toString() + ", " + opnd2.toString() + "}";
	}

}
