package ast;

public class DSimple extends Ds {

	private T tipo;
	private String id;

	public DSimple(String id, T tipo) {
		this.tipo = tipo;
		this.id = id;
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
		return TipoDs.DSIMPLE;
	}
}
