package constructorast;

import ast.Ds;

public class ResulDs {
	private Ds a;
	private boolean hayDefinicion;   
	public ResulDs() {
		hayDefinicion = false;
		a = null;
	}
	public ResulDs(Ds def) {
		hayDefinicion = true;
		this.a = def;
	}
	public Ds a() {return a;}
	public boolean hayDefinicion() {return hayDefinicion;}
}
