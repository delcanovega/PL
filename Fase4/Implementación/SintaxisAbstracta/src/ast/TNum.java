package ast;

public class TNum extends T {
	
	public TNum() {
		
	}
	
	@Override
	public TipoT tipo() {
		return TipoT.NUM;
	}

	@Override
	public String toString() {
		return "num";
	}

}
