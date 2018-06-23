package constructorast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
			System.out.println(asint.parse().value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
