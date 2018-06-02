package ast;

public class Suma extends EBin {

	public Suma(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}

	@Override
	public TipoE tipo() {
		return TipoE.SUMA;
	}

}
