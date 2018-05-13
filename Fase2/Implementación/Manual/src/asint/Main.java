package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
	public static void main(String[] args) {
		try {
			Reader input = new InputStreamReader(new FileInputStream("input.txt"));
			AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(input);
			asint.Sp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
