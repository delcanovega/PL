package ast;

public class ICompuesta extends Is {

	private String id;
	private E exp;
	private Is ins;

	public ICompuesta(Is ins, String id, E exp) {
		this.id = id;
		this.exp = exp;
		this.ins = ins;
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public E exp() {
		return exp;
	}
	
	@Override
	public Is ins() {
		return ins;
	}
	
	@Override
	public TipoIs tipo() {
		return TipoIs.ICOMPUESTA;
	}

}
