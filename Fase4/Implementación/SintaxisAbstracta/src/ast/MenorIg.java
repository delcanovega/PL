package ast;

public class MenorIg extends EBin {

	public MenorIg(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.MENORIG;
	}

}
