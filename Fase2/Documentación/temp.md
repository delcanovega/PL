# No sé qué **** estoy haciendo

| | Tipo | Prioridad | Asociatividad |
|:---:|:--------------:|:-:|:-----------------------:|
| **+** | Binario infijo | 0 | Asociativo a izquierdas |
| **-** | Binario infijo | 0 | Asociativo a izquierdas |
|**and**| Binario infijo | 1 | Asociativo a derechas   |
| **or**| Binario infijo | 1 | No asocia               |
| **>** | Binario infijo | 2 | No asocia               |
| **<** | Binario infijo | 2 | No asocia               |
| **>=**| Binario infijo | 2 | No asocia               |
| **<=**| Binario infijo | 2 | No asocia               |
| **==**| Binario infijo | 2 | No asocia               |
| **!=**| Binario infijo | 2 | No asocia               |
| **\***| Binario infijo | 3 | Asociativo a izquierdas |
| **/** | Binario infijo | 3 | Asociativo a izquierdas |
| **-** | Unario prefijo | 4 | Asocia                  |
|**not**| Unario prefijo | 4 | No asocia               |

## Gramática

$$G = (V_N, V_T, P, A)$$
$$V_N = \{A,B,C,D,E,F\}$$
$$V_F = \{+, -, and, or, >, <, >=, <=, ==, !=, *, /, not, \underline{(}, \underline{)}, id\}$$
