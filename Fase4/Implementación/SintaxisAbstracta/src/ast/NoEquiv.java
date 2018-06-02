package ast;

public class NoEquiv extends EBin {

	public NoEquiv(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.NOEQUIV;
	}

}
