package ast;

public class TBool extends T {
	
	public TBool() {
		
	}
	
	@Override
	public TipoT tipo() {
		return TipoT.BOOL;
	}

	@Override
	public String toString() {
		return "bool";
	}

}
