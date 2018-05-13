package errors;

import alex.UnidadLexica;
import asint.ClaseLexica;

public class GestionErroresTiny {
	public void errorLexico(int fila, String lexema) {
		System.out.println("ERROR fila " + fila + ": Caracter inesperado: " + lexema);
		System.exit(1);
	}

	public void errorSintactico(int fila, ClaseLexica encontrada, ClaseLexica... esperadas) {
		System.out.print("ERROR fila " + fila + ": Encontrado " + encontrada + " Se esperaba: ");
		for (ClaseLexica esperada : esperadas)
			System.out.print(esperada + " ");
		System.out.println();
		System.exit(1);
	}
	
	public void errorSintactico(UnidadLexica unidadLexica) {
	    System.out.println("ERROR fila " + unidadLexica.fila() + ": Elemento inexperado " + unidadLexica.value);
	    System.exit(1);
	}

	public void errorFatal(Exception e) {
		System.out.println(e);
		e.printStackTrace();
		System.exit(1);
	}
}
