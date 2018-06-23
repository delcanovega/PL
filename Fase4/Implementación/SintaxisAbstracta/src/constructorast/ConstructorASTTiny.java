/* ConstructorASTTiny.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorASTTiny.java */
package constructorast;

import ast.*;


public class ConstructorASTTiny implements ConstructorASTTinyConstants {
   private ASTiny as = new ASTiny();
   private final static int MAYOR=0;
   private final static int MENOR=1;
   private final static int MAYORIGUAL=2;
   private final static int MENORIGUAL=3;
   private final static int EQUIV=4;
   private final static int NOEQUIV=5;
   private E mkexp(int op, E opnd1, E opnd2){
     switch(op) {
      case MENOR: return as.menor(opnd1,opnd2);
      case MAYOR: return as.mayor(opnd1,opnd2);
      case MENORIGUAL: return as.menorIgual(opnd1,opnd2);
      case MAYORIGUAL: return as.mayorIgual(opnd1,opnd2);
      case EQUIV: return as.equiv(opnd1,opnd2);
      case NOEQUIV: return as.noEquiv(opnd1,opnd2);
      default: return null;
     }
   }

  final public S Sp() throws ParseException {S ast;
    ast = S();
    jj_consume_token(0);
{if ("" != null) return ast;}
    throw new Error("Missing return statement in function");
  }

  final public S S() throws ParseException {ResulDs ds; ResulIs is;
    ds = Ds();
    jj_consume_token(16);
    is = Is();
{if ("" != null) return as.decIns(ds.a(), is.a());}
    throw new Error("Missing return statement in function");
  }

  final public ResulDs Ds() throws ParseException {ResulD d; Ds fd;
    d = D();
    fd = FD(as.dSimple(d.id(), d.tipo()));
{if ("" != null) return new ResulDs(fd);}
    throw new Error("Missing return statement in function");
  }

  final public Ds FD(Ds ds) throws ParseException {ResulD d; Ds fd;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 17:{
      jj_consume_token(17);
      d = D();
      fd = FD(as.dCompuesta(ds, d.id(), d.tipo()));
{if ("" != null) return fd;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
{if ("" != null) return ds;}
    }
    throw new Error("Missing return statement in function");
  }

  final public ResulD D() throws ParseException {Token iden; T t;
    t = T();
    iden = jj_consume_token(identificador);
{if ("" != null) return new ResulD(iden.image, t);}
    throw new Error("Missing return statement in function");
  }

  final public T T() throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case bool:{
      t = jj_consume_token(bool);
{if ("" != null) return new TBool();}
      break;
      }
    case num:{
      t = jj_consume_token(num);
{if ("" != null) return new TNum();}
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ResulIs Is() throws ParseException {ResulI i; Is fi;
    i = I();
    fi = FI(as.iSimple(i.id(), i.exp()));
{if ("" != null) return new ResulIs(fi);}
    throw new Error("Missing return statement in function");
  }

  final public ResulI I() throws ParseException {Token iden; E e;
    iden = jj_consume_token(identificador);
    jj_consume_token(18);
    e = E0();
{if ("" != null) return new ResulI(iden.image, e);}
    throw new Error("Missing return statement in function");
  }

  final public Is FI(Is is) throws ParseException {ResulI i; Is fi;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 17:{
      jj_consume_token(17);
      i = I();
      fi = FI(as.iCompuesta(is, i.id(), i.exp()));
{if ("" != null) return fi;}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
{if ("" != null) return is;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E0() throws ParseException {E e1, e0;
    e1 = E1();
    e0 = RE0(e1);
{if ("" != null) return e0;}
    throw new Error("Missing return statement in function");
  }

  final public E RE0(E e) throws ParseException {E e1, e0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 19:{
      jj_consume_token(19);
      e1 = E1();
      e0 = RE0(as.suma(e, e1));
{if ("" != null) return e0;}
      break;
      }
    case 20:{
      jj_consume_token(20);
      e1 = E1();
      e0 = RE0(as.resta(e, e1));
{if ("" != null) return e0;}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
{if ("" != null) return e;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E1() throws ParseException {E e2, e1;
    e2 = E2();
    e1 = FE1(e2);
{if ("" != null) return e1;}
    throw new Error("Missing return statement in function");
  }

  final public E FE1(E e) throws ParseException {E e2;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:{
      jj_consume_token(and);
      e2 = E1();
{if ("" != null) return as.and(e, e2);}
      break;
      }
    case or:{
      jj_consume_token(or);
      e2 = E2();
{if ("" != null) return as.or(e, e2);}
      break;
      }
    default:
      jj_la1[4] = jj_gen;
{if ("" != null) return e;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E2() throws ParseException {E e3, e2;
    e3 = E3();
    e2 = FE2(e3);
{if ("" != null) return e2;}
    throw new Error("Missing return statement in function");
  }

  final public E FE2(E e) throws ParseException {E e3; int op;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
    case 30:{
      op = OP();
      e3 = E3();
{if ("" != null) return mkexp(op, e, e3);}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
{if ("" != null) return e;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E3() throws ParseException {E e4, e3;
    e4 = E4();
    e3 = RE3(e4);
{if ("" != null) return e3;}
    throw new Error("Missing return statement in function");
  }

  final public E RE3(E e) throws ParseException {E e4, e3;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 21:{
      jj_consume_token(21);
      e4 = E4();
      e3 = RE3(as.mul(e, e4));
{if ("" != null) return e3;}
      break;
      }
    case 22:{
      jj_consume_token(22);
      e4 = E4();
      e3 = RE3(as.div(e, e4));
{if ("" != null) return e3;}
      break;
      }
    default:
      jj_la1[6] = jj_gen;
{if ("" != null) return e;}
    }
    throw new Error("Missing return statement in function");
  }

  final public E E4() throws ParseException {E e;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 20:{
      jj_consume_token(20);
      e = E4();
{if ("" != null) return as.neg(e);}
      break;
      }
    case not:{
      jj_consume_token(not);
      e = E5();
{if ("" != null) return as.not(e);}
      break;
      }
    case ttrue:
    case ffalse:
    case identificador:
    case numero:
    case 23:{
      e = E5();
{if ("" != null) return e;}
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public E E5() throws ParseException {Token t; E e0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 23:{
      jj_consume_token(23);
      e0 = E0();
      jj_consume_token(24);
{if ("" != null) return e0;}
      break;
      }
    case identificador:{
      t = jj_consume_token(identificador);
{if ("" != null) return as.id(t.image);}
      break;
      }
    case numero:{
      t = jj_consume_token(numero);
{if ("" != null) return as.numReal(t.image);}
      break;
      }
    case ttrue:{
      t = jj_consume_token(ttrue);
{if ("" != null) return as.eTrue();}
      break;
      }
    case ffalse:{
      t = jj_consume_token(ffalse);
{if ("" != null) return as.eFalse();}
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public int OP() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 25:{
      jj_consume_token(25);
{if ("" != null) return MENOR;}
      break;
      }
    case 26:{
      jj_consume_token(26);
{if ("" != null) return MAYOR;}
      break;
      }
    case 27:{
      jj_consume_token(27);
{if ("" != null) return MENORIGUAL;}
      break;
      }
    case 28:{
      jj_consume_token(28);
{if ("" != null) return MAYORIGUAL;}
      break;
      }
    case 29:{
      jj_consume_token(29);
{if ("" != null) return EQUIV;}
      break;
      }
    case 30:{
      jj_consume_token(30);
{if ("" != null) return NOEQUIV;}
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public ConstructorASTTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20000,0x180,0x20000,0x180000,0x1800,0x7e000000,0x600000,0x90e600,0x80c600,0x7e000000,};
   }

  /** Constructor with InputStream. */
  public ConstructorASTTiny(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConstructorASTTiny(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ConstructorASTTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ConstructorASTTiny(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ConstructorASTTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConstructorASTTiny(ConstructorASTTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConstructorASTTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[31];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 31; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
