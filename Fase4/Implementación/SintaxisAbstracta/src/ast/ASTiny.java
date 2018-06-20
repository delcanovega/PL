package ast; 

public class ASTiny {
	
	public E suma(E opnd1, E opnd2) {return new Suma(opnd1,opnd2);}  
	public E resta(E opnd1, E opnd2) {return new Resta(opnd1,opnd2);}  
	public E mul(E opnd1, E opnd2) {return new Mul(opnd1,opnd2);}  
	public E div(E opnd1, E opnd2) {return new Div(opnd1,opnd2);}
	public E menor(E opnd1, E opnd2) {return new Menor(opnd1,opnd2);}
	public E menorIgual(E opnd1, E opnd2) {return new MenorIg(opnd1,opnd2);}
	public E mayor(E opnd1, E opnd2) {return new Mayor(opnd1,opnd2);}
	public E mayorIgual(E opnd1, E opnd2) {return new MayorIg(opnd1,opnd2);}
	public E equiv(E opnd1, E opnd2) {return new Equiv(opnd1,opnd2);}
	public E noEquiv(E opnd1, E opnd2) {return new NoEquiv(opnd1,opnd2);}
	public E and(E opnd1, E opnd2) {return new And(opnd1,opnd2);}
	public E or(E opnd1, E opnd2) {return new Or(opnd1,opnd2);}
	public E not(E opnd1) {return new Not(opnd1);}
	public E neg(E opnd1) {return new Neg(opnd1);}	
	public E numReal(String st) {return new NumReal(st);} 
	public E eTrue() {return new True();} 
	public E eFalse() {return new False();} 
	public E id(String id) {return new Iden(id);}  
	public T tBool() {return new TBool();}
	public T tNum() {return new TNum();}
	public Ds dSimple(String id, T tipo) {return new DSimple(id, tipo);}
	public Ds dCompuesta(Ds decs, String id, T tipo) {return new DCompuesta(decs,id,tipo);}	
	public Is iSimple(String id, E exp) {return new ISimple(id, exp);}
	public Is iCompuesta(Is ins, String id, E exp) {return new ICompuesta(ins, id, exp);}
	public S decIns(Ds decs, Is ins) {return new DecIns(decs, ins);}
	
}
