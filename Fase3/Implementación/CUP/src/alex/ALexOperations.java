package alex;

import asint.ClaseLexica;

public class ALexOperations {
	
	private AnalizadorLexicoTiny alex;

	public ALexOperations(AnalizadorLexicoTiny alex) {
		this.alex = alex;
	}

	public UnidadLexica unidadId() {
		return new UnidadLexicaMultivaluada(alex.fila(), ClaseLexica.IDEN, alex.lexema());
	}

	public UnidadLexica unidadBool() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.BOOL, "bool");
	}

	public UnidadLexica unidadNum() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.NUM, "num");
	}

	public UnidadLexica unidadTrue() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.TRUE, "true");
	}

	public UnidadLexica unidadFalse() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.FALSE, "false");
	}

	public UnidadLexica unidadAnd() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.AND, "and");
	}

	public UnidadLexica unidadOr() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.OR, "or");
	}

	public UnidadLexica unidadNot() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.NOT, "not");
	}

	public UnidadLexica unidadNumero() {
		return new UnidadLexicaMultivaluada(alex.fila(), ClaseLexica.NUMERO, alex.lexema());
	}

	public UnidadLexica unidadMas() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MAS, "+");
	}

	public UnidadLexica unidadMenos() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MENOS, "-");
	}

	public UnidadLexica unidadPor() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.POR, "*");
	}

	public UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.DIV, "/");
	}

	public UnidadLexica unidadPAb() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PAB, "(");
	}

	public UnidadLexica unidadPCe() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PCE, ")");
	}

	public UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.IGUAL, "=");
	}

	public UnidadLexica unidadPComa() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.PCOMA, ";");
	}

	public UnidadLexica unidadEquiv() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.EQUIV, "==");
	}

	public UnidadLexica unidadNoEquiv() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.NOEQUIV, "!=");
	}

	public UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MAYOR, ">");
	}

	public UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MENOR, "<");
	}

	public UnidadLexica unidadMayorIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MAYORIGUAL, ">=");
	}

	public UnidadLexica unidadMenorIgual() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.MENORIGUAL, "<=");
	}

	public UnidadLexica unidadEnd() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.END, "&&");
	}

	public UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(alex.fila(), ClaseLexica.EOF, "<EOF>");
	}
}
