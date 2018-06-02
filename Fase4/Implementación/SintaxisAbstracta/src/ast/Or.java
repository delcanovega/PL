package ast;

public class Or extends EBin {

	public Or(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.OR;
	}

}
