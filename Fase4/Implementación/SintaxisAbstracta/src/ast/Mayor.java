package ast;

public class Mayor extends EBin {

	public Mayor(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.MAYOR;
	}

}
