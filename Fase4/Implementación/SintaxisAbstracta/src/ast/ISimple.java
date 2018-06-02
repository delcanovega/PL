package ast;

public class ISimple extends Is {

	private String id;
	private E exp;

	public ISimple(String id, E exp) {
		this.id = id;
		this.exp = exp;
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
	public TipoIs tipo() {
		return TipoIs.ISIMPLE;
	}

}
