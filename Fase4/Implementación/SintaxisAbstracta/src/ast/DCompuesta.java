package ast;

public class DCompuesta extends Ds {

	private T tipo;
	private String id;
	private Ds decs;

	public DCompuesta(Ds decs, String id, T tipo) {
		this.tipo = tipo;
		this.id = id;
		this.decs = decs;
	}

	@Override
	public Ds decs() {
		return decs;
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public T tipoT() {
		return tipo;
	}

	@Override
	public TipoDs tipo() {
		return TipoDs.DCOMPUESTA;
	}

	@Override
	public String toString() {
		return "DCompuesta{ DSimple{ " + tipo.toString() + ", " + id + "}; , " + decs.toString() + "}";
	}
}
