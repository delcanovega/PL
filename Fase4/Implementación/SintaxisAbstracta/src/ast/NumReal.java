package ast;

public class NumReal extends E {
	
	private String v;

	public NumReal(String v) {
		this.v = v;
	}

	@Override
	public String val() {
		return v;
	}

	@Override
	public TipoE tipo() {
		return TipoE.NUMREAL;
	}
	
	@Override
	public String toString() {
		return v;
	}
}
