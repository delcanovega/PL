package ast;

public class Iden extends E{
	private String id;
	public Iden(String id) {
		this.id = id;   
	}
	public String id() {return id;}
	public TipoE tipo() {return TipoE.IDEN;}
}
