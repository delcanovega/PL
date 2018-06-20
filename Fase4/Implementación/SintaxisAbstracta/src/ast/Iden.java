package ast;

public class Iden extends E {
	
	private String id;

	public Iden(String id) {
		this.id = id;
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public TipoE tipo() {
		return TipoE.IDEN;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
