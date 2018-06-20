package ast;

public class Equiv extends EBin {

	public Equiv(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.EQUIV;
	}
	
	@Override
	public String toString() {
		return "equiv{ " + opnd1.toString() + ", " + opnd2.toString() + "}";
	}

}
