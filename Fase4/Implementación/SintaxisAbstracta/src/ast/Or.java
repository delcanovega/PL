package ast;

public class Or extends EBin {

	public Or(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.OR;
	}
	
	@Override
	public String toString() {
		return "or{ " + opnd1.toString() + ", " + opnd2.toString() + "}";
	}

}
