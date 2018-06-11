package constructorast;

import ast.T;

public class ResulD {
	private String id;
	private T tipo;

	public ResulD(String id, T tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	public String id() {return id;}  
	public T tipo() {return tipo;}
}
