package asint;

import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import alex.UnidadLexica;
import errors.GestionErroresTiny;

import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintacticoTiny {
	private UnidadLexica anticipo;
	private AnalizadorLexicoTiny alex;
	private GestionErroresTiny errores;

	public AnalizadorSintacticoTiny(Reader input) {
		errores = new GestionErroresTiny();
		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();
	}

	public void Sp() {
		S();
		empareja(ClaseLexica.EOF);
	}

	private void S() {
		switch (anticipo.clase()) {
		case NUM:
		case BOOL:
			Ds();
			empareja(ClaseLexica.END);
			Is();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NUM, ClaseLexica.BOOL);
		}
	}

	private void Ds() {
		switch (anticipo.clase()) {
		case NUM:
		case BOOL:
			D();
			FD();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NUM, ClaseLexica.BOOL);
		}
	}

	private void D() {
		switch (anticipo.clase()) {
		case NUM:
		case BOOL:
			T();
			empareja(ClaseLexica.IDEN);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NUM, ClaseLexica.BOOL);
		}
	}

	private void T() {
		switch (anticipo.clase()) {
		case NUM:
			empareja(ClaseLexica.NUM);
			break;
		case BOOL:
			empareja(ClaseLexica.BOOL);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.NUM, ClaseLexica.BOOL);
		}
	}

	private void FD() {
		switch (anticipo.clase()) {
		case PCOMA:
			empareja(ClaseLexica.PCOMA);
			D();
			FD();
			break;
		case END:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PCOMA);
		}
	}

	private void Is() {
		switch (anticipo.clase()) {
		case IDEN:
			I();
			FI();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN);
		}
	}

	private void I() {
		switch (anticipo.clase()) {
		case IDEN:
			empareja(ClaseLexica.IDEN);
			empareja(ClaseLexica.IGUAL);
			E0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.IDEN);
		}
	}

	private void FI() {
		switch (anticipo.clase()) {
		case PCOMA:
			empareja(ClaseLexica.PCOMA);
			I();
			FI();
			break;
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PCOMA);
		}
	}

	private void E0() {
		switch (anticipo.clase()) {
		case MENOS:
		case NOT:
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			E1();
			RE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAB,
					ClaseLexica.IDEN, ClaseLexica.NUMERO, ClaseLexica.TRUE,
					ClaseLexica.FALSE);
		}
	}

	private void RE0() {
		switch (anticipo.clase()) {
		case MAS:
			empareja(ClaseLexica.MAS);
			E1();
			RE0();
			break;
		case MENOS:
			empareja(ClaseLexica.MENOS);
			E1();
			RE0();
			break;
		case PCE:
		case PCOMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MAS, ClaseLexica.MENOS);
		}
	}

	private void E1() {
		switch (anticipo.clase()) {
		case MENOS:
		case NOT:
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			E2();
			RE1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAB,
					ClaseLexica.IDEN, ClaseLexica.NUMERO, ClaseLexica.TRUE,
					ClaseLexica.FALSE);
		}
	}

	private void RE1() {
		switch (anticipo.clase()) {
		case AND:
			empareja(ClaseLexica.AND);
			E1();
			break;
		case OR:
			empareja(ClaseLexica.OR);
			E2();
			break;
		case MAS:
		case MENOS:
		case PCE:
		case PCOMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.AND, ClaseLexica.OR);
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case MENOS:
		case NOT:
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			E3();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAB,
					ClaseLexica.IDEN, ClaseLexica.NUMERO, ClaseLexica.TRUE,
					ClaseLexica.FALSE);
		}
	}

	private void RE2() {
		switch (anticipo.clase()) {
		case MENOR:
		case MAYOR:
		case MENORIGUAL:
		case MAYORIGUAL:
		case EQUIV:
		case NOEQUIV:
			OP();
			E3();
			break;
		case AND:
		case OR:
		case MAS:
		case MENOS:
		case PCE:
		case PCOMA:
		case EOF:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOR, ClaseLexica.MAYOR,
					ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL,
					ClaseLexica.EQUIV, ClaseLexica.NOEQUIV);
		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case MENOS:
		case NOT:
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			E4();
			RE3();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAB,
					ClaseLexica.IDEN, ClaseLexica.NUMERO, ClaseLexica.TRUE,
					ClaseLexica.FALSE);
		}
	}

	private void RE3() {
		switch (anticipo.clase()) {
		case POR:
			empareja(ClaseLexica.POR);
			E4();
			RE3();
			break;
		case DIV:
			empareja(ClaseLexica.DIV);
			E4();
			RE3();
			break;
		case MENOR:
		case MAYOR:
		case MENORIGUAL:
		case MAYORIGUAL:
		case EQUIV:
		case NOEQUIV:
		case AND:
		case OR:
		case MAS:
		case MENOS:
		case PCE:
		case PCOMA:
		case EOF:
		case NOT:
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.POR, ClaseLexica.DIV);
		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case MENOS:
			empareja(ClaseLexica.MENOS);
			E4();
			break;
		case NOT:
			empareja(ClaseLexica.NOT);
			E5();
			break;
		case PAB:
		case IDEN:
		case NUMERO:
		case TRUE:
		case FALSE:
			E5();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOS, ClaseLexica.NOT, ClaseLexica.PAB,
					ClaseLexica.IDEN, ClaseLexica.NUMERO, ClaseLexica.TRUE,
					ClaseLexica.FALSE);
		}
	}

	private void E5() {
		switch (anticipo.clase()) {
		case PAB:
			empareja(ClaseLexica.PAB);
			E0();
			empareja(ClaseLexica.PCE);
			break;
		case IDEN:
			empareja(ClaseLexica.IDEN);
			break;
		case NUMERO:
			empareja(ClaseLexica.NUMERO);
			break;
		case TRUE:
			empareja(ClaseLexica.TRUE);
			break;
		case FALSE:
			empareja(ClaseLexica.FALSE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.PAB, ClaseLexica.IDEN, ClaseLexica.NUMERO,
					ClaseLexica.TRUE, ClaseLexica.FALSE);
		}
	}

	private void OP() {
		switch (anticipo.clase()) {
		case MENOR:
			empareja(ClaseLexica.MENOR);
			break;
		case MAYOR:
			empareja(ClaseLexica.MAYOR);
			break;
		case MENORIGUAL:
			empareja(ClaseLexica.MENORIGUAL);
			break;
		case MAYORIGUAL:
			empareja(ClaseLexica.MAYORIGUAL);
			break;
		case EQUIV:
			empareja(ClaseLexica.EQUIV);
			break;
		case NOEQUIV:
			empareja(ClaseLexica.NOEQUIV);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					ClaseLexica.MENOR, ClaseLexica.MAYOR,
					ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL,
					ClaseLexica.EQUIV, ClaseLexica.NOEQUIV);
		}
	}

	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
					claseEsperada);
	}

	private void sigToken() {
		try {
			anticipo = alex.yylex();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}

}
