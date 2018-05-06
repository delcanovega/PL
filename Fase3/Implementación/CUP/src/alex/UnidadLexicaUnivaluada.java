package alex;

public class UnidadLexicaUnivaluada extends UnidadLexica {

	public UnidadLexicaUnivaluada(int fila, int clase, String lexema) {
		super(fila, clase, lexema);  
	}

	@Override
	public String lexema() {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return "[clase:" + clase() + ",fila:" + fila() + "]";
	}

}
