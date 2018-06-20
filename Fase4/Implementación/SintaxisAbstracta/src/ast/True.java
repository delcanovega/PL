package ast;

public class True extends E {
	
	private String id;
	
	public True() {
		id = "true";
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public TipoE tipo() {
		return TipoE.TRUE;
	}
}
