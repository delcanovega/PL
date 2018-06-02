package ast;

public abstract class Ds {
		
	public T tipoT() {
		throw new UnsupportedOperationException("tipo");
	}
	
	public String id() {
		throw new UnsupportedOperationException("id");
	}
	
	public Ds decs() {
		throw new UnsupportedOperationException("decs");
	}
	
	public abstract TipoDs tipo();
}
