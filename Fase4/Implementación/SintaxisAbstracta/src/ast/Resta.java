package ast;

public class Resta extends EBin {
	
	public Resta(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}

	@Override
	public TipoE tipo() {
		return TipoE.RESTA;
	}

}
