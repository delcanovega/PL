package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) {
		try {
			Reader input = new InputStreamReader(new FileInputStream("input.txt"));
			AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
			UnidadLexica unidad;
			do {
				unidad = al.yylex();
				System.out.println(unidad);
			} while (unidad.clase() != ClaseLexica.EOF);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
