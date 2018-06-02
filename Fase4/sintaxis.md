# Sintaxis abstracta

## Gramática original (Fase 2)

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

### Simplificación de la gramática

    S -> Ds && Is


    Ds -> T identificador | Ds; T identificador
    T -> num | bool


    Is -> identificador = E | Is; identificador = E
    E -> E + E | E - E | E * E | E / E | E and E | E or E |
         E < E | E > E | E <= E | E >= E | E == E | E != E |
         -E | not E | identificador | numReal | true | false | (E)

## Constructoras

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
