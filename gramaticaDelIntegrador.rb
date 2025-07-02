<programa> ::= INI <bloque> FIN
<bloque> ::= "{" <lista_instrucciones> "}"
<lista_instrucciones> ::= <instruccion> <lista_instrucciones> | ε
<instruccion> ::= <asignacion>
                         | <repeticion>
                         | <condicional>
                         | <intercambio>
                         | <impresion>
<asignacion> ::= <identificador> "=" <expresion> ";"
<repeticion> ::= REPEAT <bloque>
<condicional> ::= CHECK "(" <condicion> ")" <bloque>
<intercambio> ::= INTER "(" <identificador> "," <identificador> ")" ";"
<impresion> ::= PRINT "(" <identificador> ")" ";"
<condicion> ::= <identificador> <operador_comp> <identificador>
                       | <identificador> <operador_comp> <numero>
<operador_comp> ::= "==" | "<" | ">"
<expresion> ::= <numero> | <identificador>
<identificador> ::= [a-z][a-z0-9]*
<numero> ::= -?[0-9]+
