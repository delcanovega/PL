package ast;

public class Menor extends EBin {

	public Menor(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.MENOR;
	}

}
