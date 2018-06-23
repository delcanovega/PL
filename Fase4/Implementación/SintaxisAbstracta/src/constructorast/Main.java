package constructorast;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
	 ConstructorASTTiny asint = new ConstructorASTTiny(input);
        System.out.println(asint.S());
 }
}   