
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140220
// Sun May 13 13:39:20 CEST 2018
//----------------------------------------------------

package asint;

import java_cup.runtime.*;
import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;
import errors.GestionErroresTiny;
import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b beta 20140220 generated parser.
  * @version Sun May 13 13:39:20 CEST 2018
  */
public class AnalizadorSintacticoTiny extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoTiny() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoTiny(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\043\000\002\002\005\000\002\002\004\000\002\003" +
    "\003\000\002\003\005\000\002\004\004\000\002\005\003" +
    "\000\002\005\003\000\002\006\003\000\002\006\005\000" +
    "\002\007\005\000\002\010\005\000\002\010\005\000\002" +
    "\010\003\000\002\011\005\000\002\011\005\000\002\011" +
    "\003\000\002\012\005\000\002\012\003\000\002\013\005" +
    "\000\002\013\005\000\002\013\003\000\002\014\004\000" +
    "\002\014\004\000\002\014\003\000\002\015\005\000\002" +
    "\015\003\000\002\015\003\000\002\015\003\000\002\015" +
    "\003\000\002\016\003\000\002\016\003\000\002\016\003" +
    "\000\002\016\003\000\002\016\003\000\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\006\004\004\005\007\001\002\000\004\006" +
    "\ufffc\001\002\000\004\006\071\001\002\000\004\002\070" +
    "\001\002\000\004\006\ufffb\001\002\000\006\010\066\011" +
    "\uffff\001\002\000\004\011\012\001\002\000\004\006\015" +
    "\001\002\000\006\002\ufffa\010\064\001\002\000\004\002" +
    "\001\001\002\000\004\014\016\001\002\000\020\006\020" +
    "\007\021\012\017\013\022\023\026\032\031\033\032\001" +
    "\002\000\040\002\uffe6\010\uffe6\015\uffe6\016\uffe6\017\uffe6" +
    "\020\uffe6\021\uffe6\022\uffe6\024\uffe6\025\uffe6\026\uffe6\027" +
    "\uffe6\030\uffe6\031\uffe6\034\uffe6\001\002\000\040\002\uffe8" +
    "\010\uffe8\015\uffe8\016\uffe8\017\uffe8\020\uffe8\021\uffe8\022" +
    "\uffe8\024\uffe8\025\uffe8\026\uffe8\027\uffe8\030\uffe8\031\uffe8" +
    "\034\uffe8\001\002\000\040\002\uffe7\010\uffe7\015\uffe7\016" +
    "\uffe7\017\uffe7\020\uffe7\021\uffe7\022\uffe7\024\uffe7\025\uffe7" +
    "\026\uffe7\027\uffe7\030\uffe7\031\uffe7\034\uffe7\001\002\000" +
    "\040\002\uffe5\010\uffe5\015\uffe5\016\uffe5\017\uffe5\020\uffe5" +
    "\021\uffe5\022\uffe5\024\uffe5\025\uffe5\026\uffe5\027\uffe5\030" +
    "\uffe5\031\uffe5\034\uffe5\001\002\000\040\002\uffea\010\uffea" +
    "\015\uffea\016\uffea\017\uffea\020\uffea\021\uffea\022\uffea\024" +
    "\uffea\025\uffea\026\uffea\027\uffea\030\uffea\031\uffea\034\uffea" +
    "\001\002\000\040\002\uffed\010\uffed\015\uffed\016\uffed\017" +
    "\uffed\020\uffed\021\uffed\022\uffed\024\uffed\025\uffed\026\uffed" +
    "\027\uffed\030\uffed\031\uffed\034\uffed\001\002\000\040\002" +
    "\ufff0\010\ufff0\015\ufff0\016\ufff0\017\054\020\057\021\ufff0" +
    "\022\ufff0\024\056\025\052\026\055\027\050\030\053\031" +
    "\060\034\ufff0\001\002\000\014\006\020\007\021\012\017" +
    "\013\022\033\032\001\002\000\020\002\ufff2\010\ufff2\015" +
    "\ufff2\016\ufff2\021\043\022\044\034\ufff2\001\002\000\014" +
    "\002\ufff5\010\ufff5\015\ufff5\016\ufff5\034\ufff5\001\002\000" +
    "\020\006\020\007\021\012\017\013\022\023\026\032\031" +
    "\033\032\001\002\000\020\006\020\007\021\012\017\013" +
    "\022\023\026\032\031\033\032\001\002\000\012\002\ufff8" +
    "\010\ufff8\015\034\016\035\001\002\000\020\006\020\007" +
    "\021\012\017\013\022\023\026\032\031\033\032\001\002" +
    "\000\020\006\020\007\021\012\017\013\022\023\026\032" +
    "\031\033\032\001\002\000\014\002\ufff6\010\ufff6\015\ufff6" +
    "\016\ufff6\034\ufff6\001\002\000\014\002\ufff7\010\ufff7\015" +
    "\ufff7\016\ufff7\034\ufff7\001\002\000\010\015\034\016\035" +
    "\034\041\001\002\000\040\002\uffe9\010\uffe9\015\uffe9\016" +
    "\uffe9\017\uffe9\020\uffe9\021\uffe9\022\uffe9\024\uffe9\025\uffe9" +
    "\026\uffe9\027\uffe9\030\uffe9\031\uffe9\034\uffe9\001\002\000" +
    "\040\002\uffec\010\uffec\015\uffec\016\uffec\017\uffec\020\uffec" +
    "\021\uffec\022\uffec\024\uffec\025\uffec\026\uffec\027\uffec\030" +
    "\uffec\031\uffec\034\uffec\001\002\000\020\006\020\007\021" +
    "\012\017\013\022\023\026\032\031\033\032\001\002\000" +
    "\020\006\020\007\021\012\017\013\022\023\026\032\031" +
    "\033\032\001\002\000\014\002\ufff3\010\ufff3\015\ufff3\016" +
    "\ufff3\034\ufff3\001\002\000\014\002\ufff4\010\ufff4\015\ufff4" +
    "\016\ufff4\034\ufff4\001\002\000\040\002\uffeb\010\uffeb\015" +
    "\uffeb\016\uffeb\017\uffeb\020\uffeb\021\uffeb\022\uffeb\024\uffeb" +
    "\025\uffeb\026\uffeb\027\uffeb\030\uffeb\031\uffeb\034\uffeb\001" +
    "\002\000\020\006\uffe2\007\uffe2\012\uffe2\013\uffe2\023\uffe2" +
    "\032\uffe2\033\uffe2\001\002\000\020\006\020\007\021\012" +
    "\017\013\022\023\026\032\031\033\032\001\002\000\020" +
    "\006\uffe4\007\uffe4\012\uffe4\013\uffe4\023\uffe4\032\uffe4\033" +
    "\uffe4\001\002\000\020\006\uffe0\007\uffe0\012\uffe0\013\uffe0" +
    "\023\uffe0\032\uffe0\033\uffe0\001\002\000\020\006\020\007" +
    "\021\012\017\013\022\023\026\032\031\033\032\001\002" +
    "\000\020\006\uffe1\007\uffe1\012\uffe1\013\uffe1\023\uffe1\032" +
    "\uffe1\033\uffe1\001\002\000\020\006\uffe3\007\uffe3\012\uffe3" +
    "\013\uffe3\023\uffe3\032\uffe3\033\uffe3\001\002\000\020\006" +
    "\020\007\021\012\017\013\022\023\026\032\031\033\032" +
    "\001\002\000\020\006\uffdf\007\uffdf\012\uffdf\013\uffdf\023" +
    "\uffdf\032\uffdf\033\uffdf\001\002\000\040\002\uffee\010\uffee" +
    "\015\uffee\016\uffee\017\uffee\020\uffee\021\uffee\022\uffee\024" +
    "\uffee\025\uffee\026\uffee\027\uffee\030\uffee\031\uffee\034\uffee" +
    "\001\002\000\040\002\uffef\010\uffef\015\uffef\016\uffef\017" +
    "\uffef\020\uffef\021\uffef\022\uffef\024\uffef\025\uffef\026\uffef" +
    "\027\uffef\030\uffef\031\uffef\034\uffef\001\002\000\024\002" +
    "\ufff1\010\ufff1\015\ufff1\016\ufff1\017\054\020\057\021\ufff1" +
    "\022\ufff1\034\ufff1\001\002\000\004\006\015\001\002\000" +
    "\004\002\ufff9\001\002\000\006\004\004\005\007\001\002" +
    "\000\004\011\ufffe\001\002\000\004\002\000\001\002\000" +
    "\006\010\ufffd\011\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\067\000\012\002\005\003\010\004\007\005\004\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\006\013\007\012\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\016\010\032\011\027\012" +
    "\026\013\024\014\023\015\022\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\016\050\001\001" +
    "\000\004\015\046\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\014\041\015\022\001\001\000\016\010\037" +
    "\011\027\012\026\013\024\014\023\015\022\001\001\000" +
    "\002\001\001\000\014\011\036\012\026\013\024\014\023" +
    "\015\022\001\001\000\014\011\035\012\026\013\024\014" +
    "\023\015\022\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\014\011\045\012\026\013\024\014\023\015\022\001\001" +
    "\000\014\011\044\012\026\013\024\014\023\015\022\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\013\062\014\023\015\022\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\014\061" +
    "\015\022\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\014\060\015\022\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\006" +
    "\064\007\012\001\001\000\002\001\001\000\010\003\066" +
    "\004\007\005\004\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoTiny$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoTiny$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoTiny$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** User initialization code. */
  public void user_init() throws java.lang.Exception
    {
 
   errores = new GestionErroresTiny();
   AnalizadorLexicoTiny alex = (AnalizadorLexicoTiny)getScanner();
   alex.fijaGestionErrores(errores);

    }

  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {
 return getScanner().next_token(); 
    }

 
   private GestionErroresTiny errores;
   public void syntax_error(Symbol unidadLexica) {
     errores.errorSintactico((UnidadLexica)unidadLexica);
   }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoTiny$actions {
  private final AnalizadorSintacticoTiny parser;

  /** Constructor */
  CUP$AnalizadorSintacticoTiny$actions(AnalizadorSintacticoTiny parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action_part00000000(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoTiny$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // S ::= Ds END Is 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("S",0, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= S EOF 
            {
              Object RESULT =null;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoTiny$stack.elementAt(CUP$AnalizadorSintacticoTiny$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoTiny$parser.done_parsing();
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Ds ::= D 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Ds",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Ds ::= D PCOMA Ds 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Ds",1, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // D ::= T IDEN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("D",2, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // T ::= NUM 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("T",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // T ::= BOOL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("T",3, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Is ::= I 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Is",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Is ::= I PCOMA Is 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("Is",4, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // I ::= IDEN IGUAL E0 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("I",5, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // E0 ::= E0 MAS E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E0",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // E0 ::= E0 MENOS E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E0",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E0 ::= E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E0",6, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E1 ::= E2 AND E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E1 ::= E2 OR E1 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E1 ::= E2 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E1",7, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E2 ::= E3 OP E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // E2 ::= E3 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E2",8, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // E3 ::= E3 POR E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // E3 ::= E3 DIV E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // E3 ::= E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E3",9, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // E4 ::= NEG E4 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // E4 ::= NOT E5 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // E4 ::= E5 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E4",10, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // E5 ::= PAB E0 PCE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E5",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // E5 ::= IDEN 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E5",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // E5 ::= NUMERO 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E5",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // E5 ::= TRUE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E5",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // E5 ::= FALSE 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("E5",11, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // OP ::= MENOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // OP ::= MAYOR 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // OP ::= MENORIGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // OP ::= MAYORIGUAL 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // OP ::= EQUIV 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // OP ::= NOEQUIV 
            {
              Object RESULT =null;

              CUP$AnalizadorSintacticoTiny$result = parser.getSymbolFactory().newSymbol("OP",12, RESULT);
            }
          return CUP$AnalizadorSintacticoTiny$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintacticoTiny$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoTiny$do_action(
    int                        CUP$AnalizadorSintacticoTiny$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoTiny$parser,
    java.util.Stack            CUP$AnalizadorSintacticoTiny$stack,
    int                        CUP$AnalizadorSintacticoTiny$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintacticoTiny$do_action_part00000000(
                               CUP$AnalizadorSintacticoTiny$act_num,
                               CUP$AnalizadorSintacticoTiny$parser,
                               CUP$AnalizadorSintacticoTiny$stack,
                               CUP$AnalizadorSintacticoTiny$top);
    }
}

