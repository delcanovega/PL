package ast;

public class Neg extends EUn {
	
	public Neg(E opnd){
		super(opnd);
	}
	
	@Override
	public TipoE tipo() {
		return TipoE.NEG;
	}
}
