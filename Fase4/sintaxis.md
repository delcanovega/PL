# Sintaxis abstracta

## 1.   Obtención de funciones costructoras

### 1.1 Gramática original (Fase 2)

    S  -> Ds && Is


    Ds -> D | D; Ds
    D  -> T identificador
    T  -> num | bool


    Is -> I | I; Is
    I  -> identificador = E0

    E0 -> E0 + E1 | E0 - E1 | E1
    E1 -> E2 and E1 | E2 or E2 | E2
    E2 -> E3 OP E3 | E3
    E3 -> E3 * E4 | E3 / E4 | E4
    E4 -> - E4 | not E5 | E5
    E5 -> (E0) | identificador | numReal | true | false

    OP -> < | > | <= | >= | == | !=

### 1.2 Simplificación de la gramática

    S -> Ds && Is


    Ds -> T identificador | Ds; T identificador
    T -> num | bool


    Is -> identificador = E | Is; identificador = E
    E -> E + E | E - E | E * E | E / E | E and E | E or E |
         E < E | E > E | E <= E | E >= E | E == E | E != E |
         -E | not E | identificador | numReal | true | false | (E)

### 1.3 Funciones constructoras

| Regla | Constructora |
|-------|--------------|
| S -> Ds && Is | **decIns:** Ds x Is -> S |
| Ds -> T identificador | **dSimple:** T x **string** -> Ds |
| Ds -> Ds; T identificador | **dCompuesta:** Ds x T x **string** -> Ds |
| T -> num | **tNum: num** -> T |
| T -> bool | **tBool: bool** -> T|
| Is -> identificador = E | **iSimple: string** x E -> Is |
| Is -> Is; identificador = E | **iCompuesta:** Is x **string** x E -> Is |
| E -> E + E | **suma:** E x E -> E |
| E -> E - E | **resta:** E x E -> E |
| E -> E * E | **mul:** E x E -> E |
| E -> E / E | **div:** E x E -> E |
| E -> E and E | **and:** E x E -> E |
| E -> E or E | **or:** E x E -> E |
| E -> E < E | **menor:** E x E -> E |
| E -> E > E | **mayor:** E x E -> E |
| E -> E <= E | **menorIg:** E x E -> E |
| E -> E >= E | **mayorIg:** E x E -> E |
| E -> E == E | **equiv:** E x E -> E |
| E -> E != E | **noEquiv:** E x E -> E |
| E -> -E | **neg:** E -> E |
| E -> not E | **not:** E -> E |
| E -> identificador | **id: string** -> E |
| E -> numReal | **real: string** -> E |
| E -> true | **true: string** -> E |
| E -> false | **false: string** -> E |

## 2.   Sintaxis abstracta (Diagrama de clases)

((imagen))

## 3.   Gramática de atributos

    S  -> Ds && Is
      S.a = decIns(Ds.a, Is.a)

    Ds -> D
      Ds.a = dSimple(D.tipo, D.iden)
    Ds -> D; Ds
      Ds.a = dCompuesta(Ds'.a, D.tipo, D.iden)
    D  -> T identificador
      D.tipo = T.a
      D.iden = identificador.lex
    T  -> num
      T.a = tNum()
    T  -> bool
      T.a = tBool()

    Is -> I
      Is.a = iSimple(I.iden, I.exp)
    Is -> I; Is
      Is.a = iCompuesta(Is'.a, I.iden, I.exp)
    I  -> identificador = E0
      I.iden = identificador.lex
      I.exp = E0.a

    E0 -> E0 + E1
      E0.a = suma(E0'.a, E1.a)
    E0 -> E0 - E1
      E0.a = resta(E0'.a, E1.a)
    E0 -> E1
      E0.a = E1.a
    E1 -> E2 and E1
      E1.a = and(E2.a, E1'a)
    E1 -> E2 or E2
      E1.a = or(E2.a, E2'.a)
    E1 -> E2
      E1.a = E2.a
    E2 -> E3 OP E3
      E2.a = mkexp(OP.op, E3.a, E3'.a)
    E2 -> E3
      E2.a = E3.a
    E3 -> E3 * E4
      E3.a = mul(E3'.a, E4.a)
    E3 -> E3 / E4
      E3.a = div(E3'.a, E4.a)
    E3 -> E4
      E3.a = E4.a
    E4 -> - E4
      E4.a = neg(E4'.a)
    E4 -> not E5
      E4.a = not(E5.a)
    E4 -> E5
      E4.a = E5.a
    E5 -> (E0)
      E5.a = E0.a
    E5 -> identificador
      E5.a = id(identificador.lex)
    E5 -> numReal
      E5.a = numReal(numReal.lex)
    E5 -> true
      E5.a = true(true.lex)
    E5 -> false
      E5.a = false(false.lex)

    OP -> <
      OP.op = "<"
    OP -> >
      OP.op = ">"
    OP -> <=
      OP.op = "<="
    OP -> >=
      OP.op = ">="
    OP -> ==
      OP.op = "=="
    OP -> !=
      OP.op = "!="

### 3.1 Función `mkexp()`

    fun mkexp(op, opnd1, opnd2) {
        switch(op) {
            "<" => return menor(opnd1, opnd2)
            ">" => return mayor(opnd1, opnd2)
            "<=" => return menorIg(opnd1, opnd2)
            ">=" => return mayorIg(opnd1, opnd2)
            "==" => return equiv(opnd1, opnd2)
            "!=" => return noEquiv(opnd1, opnd2)
        }
    }

## 4. Acondicionamiento para implementación descendente

    S  -> Ds && Is
      S.a = decIns(Ds.a, Is.a)

    Ds -> D FD
      FD.ah = dSimple(D.tipo, D.iden)
      Ds.a = FD.a
    D  -> T identificador
      D.tipo = T.a
      D.iden = identificador.lex
    FD -> ; Ds
        FD.a = dCompuesta(FD.ah, Ds.tipo, Ds.iden)
    FD -> epsilon
        FD.a = FD.ah
    T  -> num
      T.a = tNum()
    T  -> bool
      T.a = tBool()

    Is -> I FI
      FI.ah = iSimple(I.iden, I.exp)
      Is.a = FI.a
    I  -> identificador = E0
      I.iden = identificador.lex
      I.exp = E0.a
    FI -> ; Is
        FI.a = iCompuesta(FI.ah, Is.tipo, Is.iden)
    FI -> epsilon
        FI.a = FI.ah

    E0  -> E1 E0'
      E0'.ah = E1.a
      E0.a = E0'.a
    E0' -> + E1 E0'
      E0'_.ah = suma(E0'.ah, E1.a)
      E0'.a = E0'_.a
    E0' -> - E1 E0'
      E0'_.ah = resta(E0'.ah, E1.a)
      E0'.a = E0'_.a
    E0' -> epsilon
      E0'.a = E0'.ah
    E1  -> E2 FE1
      FE1.ah = E2.a
      E1.a = FE1.a
    FE1 -> and E1 FE1
      FE1_.ah = and(FE1.ah, E1.a)
      FE1.a = FE1_.a
    FE1 -> or E2 FE1
      FE1_.ah = or(EF1.ah, E1.a)
      FE1.a = FE1_.a
    FE1 -> epsilon
      FE1.a = FE1.ah
    E2  -> E3 FE2
      FE2.ah = E3.a
      E2.a = FE2.a
    FE2 -> OP E3
      FE2.a = mkexp(OP.op, FE2.ah, E3.a)
    FE2 -> epsilon
      FE2.a = FE2.ah
    E3  -> E4 E3'
      E3'.ah = E4.a
      E3.a = E3'.a
    E3' -> * E4 E3'
      E3'_.ah = mul(E3'.ah, E4.a)
      E3'.a = E3'_.a
    E3' -> / E4 E3'
      E3'_.ah = div(E3'.ah, E4.a)
      E3'.a = E3'_.a
    E3' -> epsilon
      E3'.a = E3'.ah
    E4 -> - E4
      E4.a = neg(E4'.a)
    E4 -> not E5
      E4.a = not(E5.a)
    E4 -> E5
      E4.a = E5.a
    E5 -> (E0)
      E5.a = E0.a
    E5 -> identificador
      E5.a = id(identificador.lex)
    E5 -> numReal
      E5.a = numReal(numReal.lex)
    E5 -> true
      E5.a = true(true.lex)
    E5 -> false
      E5.a = false(false.lex)

    OP -> <
      OP.op = "<"
    OP -> >
      OP.op = ">"
    OP -> <=
      OP.op = "<="
    OP -> >=
      OP.op = ">="
    OP -> ==
      OP.op = "=="
    OP -> !=
      OP.op = "!="
