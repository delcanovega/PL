package ast;

public class DecIns extends S {
	
	private Ds decs;
	private Is ins;
	
	public DecIns(Ds decs, Is ins){
		this.decs = decs;
		this.ins = ins;
	}
	
	public Ds decs(){
		return decs;
	}
	
	public Is ins(){
		return ins;
	}
	
	public TipoS tipo(){
		 return TipoS.DECINS; 
	}

	@Override
	public String toString() {
		return "decIns(&&){ " + decs.toString() + ", " + ins.toString() + "}";
	}
}
