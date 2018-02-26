import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.PseudoColumnUsage;

public class AnalizadorLexico {
   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
	   INICIO, REC_MAS, REC_MENOS, REC_POR, REC_DIV, REC_PAB, REC_PCE, 
	   REC_PCOMA, REC_IGUAL, REC_IDEN, REC_NUMERO, REC_PUNTO, REC_DEC,
	   REC_E, REC_AUXEXP, REC_EXP, REC_MAYOR, REC_MAYORIGUAL, REC_MENOR,
	   REC_MENORIGUAL, REC_DIST, REC_NOEQUIV, REC_EQUIV, REC_END, REC_END2, REC_EOF 
   }

   private Estado estado;

   public AnalizadorLexico(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }
   
   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INICIO;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INICIO:
        	   if(hayLetra()) transita(Estado.REC_IDEN);
        	   else if(hayDigito()) transita(Estado.REC_NUMERO);
        	   else if(hayPComa()) transita(Estado.REC_PCOMA);
        	   else if(hayMul()) transita(Estado.REC_POR);
        	   else if(hayDiv()) transita(Estado.REC_DIV);
        	   else if(hayPAb()) transita(Estado.REC_PAB);
        	   else if(hayPCe()) transita(Estado.REC_PCE);
        	   else if(hayIgual()) transita(Estado.REC_IGUAL);
        	   else if(hayMas()) transita(Estado.REC_MAS);
        	   else if(hayMenos()) transita(Estado.REC_MENOS);
        	   else if(hayMayor()) transita(Estado.REC_MAYOR);
        	   else if(hayMenor()) transita(Estado.REC_MENOR);
        	   else if(hayDist())transita(Estado.REC_DIST);
        	   else if(hayEnd()) transita(Estado.REC_END);
        	   else if(haySep()) transitaIgnorando(Estado.INICIO);
        	   else if(hayEOF()) transita(Estado.REC_EOF);
        	   else error();
        	   break;
           case REC_IDEN: 
               if (hayLetra() || hayDigito() || haySub()) transita(Estado.REC_IDEN);
               else return unidadId();               
               break;
           case REC_NUMERO:
        	   if (hayPunto()) transita(Estado.REC_PUNTO);
        	   else if (hayExp()) transita(Estado.REC_E);
        	   else if (hayDigito()) transita(Estado.REC_NUMERO);
        	   else return unidadNumero();
        	   break;
           case REC_PUNTO:
        	   if (hayDigito()) transita(Estado.REC_DEC);
        	   else error();
        	   break;
           case REC_DEC:
        	   if (hayDigito()) transita(Estado.REC_DEC);
        	   else if (hayExp()) transita(Estado.REC_E);
        	   else return unidadNumero();
        	   break;
           case REC_E:
        	   if (hayMas() || hayMenos()) transita(Estado.REC_AUXEXP);
        	   else if (hayDigito()) transita(Estado.REC_EXP);
        	   else error();
        	   break;
           case REC_AUXEXP:
        	   if (hayDigito()) transita(Estado.REC_EXP);
        	   else error();
        	   break;
           case REC_EXP:
        	   if (hayDigito()) transita(Estado.REC_EXP);
        	   else return unidadNumero();
        	   break;
           case REC_MAS:
        	   if(hayDigito()) transita(Estado.REC_NUMERO);
        	   else return unidadMas();
        	   break;
           case REC_MENOS:
        	   if(hayDigito()) transita(Estado.REC_NUMERO);
        	   else return unidadMenos();
        	   break;
           case REC_PCOMA: return unidadPComa();
           case REC_POR: return unidadPor();
           case REC_DIV: return unidadDiv();              
           case REC_PAB: return unidadPAb();
           case REC_PCE: return unidadPCe();
           case REC_IGUAL: 
        	   if (hayIgual()) transita(Estado.REC_EQUIV); 
        	   else return unidadIgual();
        	   break;
           case REC_EQUIV: return unidadEquiv();
           case REC_MAYOR:
        	   if (hayIgual()) transita(Estado.REC_MAYORIGUAL);
        	   else return unidadMayor();
        	   break;
           case REC_MAYORIGUAL: return unidadMayorIgual();
           case REC_MENOR:
        	   if (hayIgual()) transita(Estado.REC_MENORIGUAL);
        	   else return unidadMenor();
        	   break;
           case REC_MENORIGUAL: return unidadMenorIgual();
           case REC_DIST:
        	   if (hayIgual()) transita(Estado.REC_NOEQUIV);
        	   else error();
        	   break;
           case REC_NOEQUIV: return unidadNoEquiv();
           case REC_END:
        	   if (hayEnd()) transita(Estado.REC_END2);
        	   else error();
        	   break;
           case REC_END2: return unidadEnd();
           case REC_EOF: return unidadEof();
         } 
     }    
   }
   private void transita(Estado sig) throws IOException {
     lex.append((char)sigCar);
     sigCar();         
     estado = sig;
   }
   private void transitaIgnorando(Estado sig) throws IOException {
     sigCar();         
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     estado = sig;
   }
   private void sigCar() throws IOException {
     sigCar = input.read();
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'z';}
   private boolean haySub() {return sigCar == '_';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean hayMas() {return sigCar == '+';}
   private boolean hayMenos() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAb() {return sigCar == '(';}
   private boolean hayPCe() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPComa() {return sigCar == ';';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean hayExp() {return sigCar == 'e' || sigCar == 'E';}
   private boolean hayMayor(){return sigCar == '>';}
   private boolean hayMenor(){return sigCar == '<';}
   private boolean hayDist() {return sigCar == '!';}
   private boolean hayEnd() {return sigCar == '&';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   private boolean hayEOF() {return sigCar == -1;}
   
   private UnidadLexica unidadId() {
     switch(lex.toString()) {
         case "bool":  
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL);
         case "num":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NUM);
         case "true":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
         case "false":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
         case "and":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
         case "or":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
         case "not":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);             
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN, lex.toString());     
      }
   }   
   private UnidadLexica unidadNumero() {
	   return new UnidadLexicaUnivaluada(filaInicio, columnaInicio,ClaseLexica.NUM);
   }
   private UnidadLexica unidadMas() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
   }    
   private UnidadLexica unidadMenos() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
   }    
   private UnidadLexica unidadPor() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
   }    
   private UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
   }    
   private UnidadLexica unidadPAb() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAB);     
   }    
   private UnidadLexica unidadPCe() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCE);     
   }    
   private UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);     
   }    
   private UnidadLexica unidadPComa() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCOMA);     
   }  
   private UnidadLexica unidadEquiv() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EQUIV);     
   }
   private UnidadLexica unidadNoEquiv() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOEQUIV);     
   }
   private UnidadLexica unidadMayor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
   }
   private UnidadLexica unidadMenor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
   }
   private UnidadLexica unidadMayorIgual() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYORIGUAL);     
   }
   private UnidadLexica unidadMenorIgual() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENORIGUAL);     
   }
   private UnidadLexica unidadEnd() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.END);     
   }
   private UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
   }    
   private void error() {
     System.err.println("("+filaActual+','+columnaActual+"):Caracter inesperado");  
     System.exit(1);
   }

   public static void main(String arg[]) throws IOException {
     Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     AnalizadorLexico al = new AnalizadorLexico(input);
     UnidadLexica unidad;
     do {
       unidad = al.sigToken();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    } 
}
