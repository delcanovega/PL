package alex;

import java_cup.runtime.Symbol;

public abstract class UnidadLexica extends Symbol {

	private int fila;

	public UnidadLexica(int fila, int clase, String lexema) {
		super(clase, lexema);
		this.fila = fila;
	}

	public int clase() {
		return sym;
	}

	public int fila() {
		return fila;
	}

	public abstract String lexema();
}
