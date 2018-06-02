package ast;

public class Div extends EBin {

	public Div(E opnd1, E opnd2) {
		super(opnd1, opnd2);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.DIV;
	}

}
