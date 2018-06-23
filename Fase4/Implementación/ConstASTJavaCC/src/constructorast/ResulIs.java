package constructorast;

import ast.Is;

public class ResulIs {
	
	private Is a;
	private boolean hayDefinicion;

	public ResulIs() {
		hayDefinicion = false;
		a = null;
	}

	public ResulIs(Is def) {
		hayDefinicion = true;
		this.a = def;
	}

	public Is a() {
		return a;
	}

	public boolean hayDefinicion() {
		return hayDefinicion;
	}

}
