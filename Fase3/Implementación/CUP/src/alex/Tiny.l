package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
    this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteDecimal = \.({digito})+
parteExponencial = [e,E]([\+,\-])?{digito}+
iden = {letra}({letra}|{digito}|\_)*
numero = ([\+,\-])?{digito}+({parteDecimal})?({parteExponencial})? 
separador = [ ,\t,\r,\b,\n]
num = num
bool = bool
true = true
false = false
and = and
or = or
not = not
operadorPComa = \;
operadorEnd = \&\&
igual = \=
operadorMas = \+
operadorMenos = \-
operadorMul = \*
operadorDiv = /
mayor = \>
menor = \<
mayorIgual = \>\=
menorIgual = \<\=
equivalente = \=\=
noEquivalente = \!\=
parentesisApertura = \(
parentesisCierre = \)
%%
{separador}               {}
{num}                	  {return ops.unidadNum();}
{bool}					  {return ops.unidadBool();}
{numero}         		  {return ops.unidadNumero();}
{true}					  {return ops.unidadTrue();}
{false}					  {return ops.unidadFalse();}
{operadorPComa}           {return ops.unidadPComa();}
{operadorEnd}             {return ops.unidadEnd();}
{igual}		              {return ops.unidadIgual();}
{operadorMas}	 		  {return ops.unidadMas();}
{operadorMenos}           {return ops.unidadMenos();}
{operadorMul}			  {return ops.unidadPor();}
{operadorDiv}			  {return ops.unidadDiv();}
{and}       		      {return ops.unidadAnd();}
{or}          			  {return ops.unidadOr();}
{not} 					  {return ops.unidadNot();}
{mayor}         		  {return ops.unidadMenor();}
{menor}         		  {return ops.unidadMayor();}
{mayorIgual}			  {return ops.unidadMayorIgual();}
{menorIgual}         	  {return ops.unidadMenorIgual();}
{equivalente}         	  {return ops.unidadEquiv();}
{noEquivalente}           {return ops.unidadNoEquiv();}
{parentesisApertura}      {return ops.unidadPAb();}
{parentesisCierre}        {return ops.unidadPCe();}
{iden}			          {return ops.unidadId();}
[^]                       {errores.errorLexico(fila(),lexema());}