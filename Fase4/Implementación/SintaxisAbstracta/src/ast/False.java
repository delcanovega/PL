package ast;

public class False extends E {

	private String id;
	
	public False() {
		id = "false";
	}
	
	@Override
	public String id() {
		return id;
	}

	@Override
	public TipoE tipo() {
		return TipoE.FALSE;
	}

	@Override
	public String toString() {
		return id;
	}
	
}