package ast;

public class NumReal extends E {
	private String v;
	public NumReal(String v) {
		this.v = v;   
	}
	public String val() {return v;}
	public TipoE tipo() {return TipoE.NUMREAL;}    
}
