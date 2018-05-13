package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;

public class Main {

	public static void main(String[] args) {
		Reader input;
		try {
			input = new InputStreamReader(new FileInputStream("input.txt"));
			AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
			AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
			asint.setScanner(alex);
			asint.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
