package ast;

public class MayorIg extends EBin {

	public MayorIg(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.MAYORIG;
	}

}
