package asint;

import java.io.FileInputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(new FileInputStream("input.txt"));
		asint.Sp();
	}
}