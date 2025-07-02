package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-z]
D=[0-9]+
espacio=[ \t\r]+
%{
    public String lexeme;
%}
%%

/* Palabras reservadas */
( INI )          { lexeme = yytext(); return INI; }
( FIN )          { lexeme = yytext(); return FIN; }
( REPEAT )       { lexeme = yytext(); return REPEAT; }
( CHECK )        { lexeme = yytext(); return CHECK; }
( INTER )        { lexeme = yytext(); return INTER; }
( PRINT )        { lexeme = yytext(); return PRINT; }
( ELSE )         { lexeme = yytext(); return ELSE; }
( WHILE )        { lexeme = yytext(); return WHILE; }
( FOR )          { lexeme = yytext(); return FOR; }
( FUNCTION )     { lexeme = yytext(); return FUNCTION; }
( RETURN )       { lexeme = yytext(); return RETURN; }
( INT )          { lexeme = yytext(); return INT; }
( LANG )         { lexeme = yytext(); return LANG; }
( ARRAY )        { lexeme = yytext(); return ARRAY; }

/* Símbolos especiales compuestos */
( "==" )         { lexeme = yytext(); return Igual_Comparacion; }
( "!=" )         { lexeme = yytext(); return Diferente; }
( "<=" )         { lexeme = yytext(); return Menor_Igual; }
( ">=" )         { lexeme = yytext(); return Mayor_Igual; }
( "&&" )         { lexeme = yytext(); return AND; }
( "||" )         { lexeme = yytext(); return OR; }

/* Símbolos especiales simples */
( "{" )          { lexeme = yytext(); return Llave_Apertura; }
( "}" )          { lexeme = yytext(); return Llave_Cierre; }
( "(" )          { lexeme = yytext(); return Parentesis_A; }
( ")" )          { lexeme = yytext(); return Parentesis_C; }
( "," )          { lexeme = yytext(); return Coma; }
( ";" )          { lexeme = yytext(); return PuntoYComa; }
( "=" )          { lexeme = yytext(); return Igual; }
( "<" )          { lexeme = yytext(); return Menor; }
( ">" )          { lexeme = yytext(); return Mayor; }
( "+" )          { lexeme = yytext(); return Suma; }
( "-" )          { lexeme = yytext(); return Resta; }
( "*" )          { lexeme = yytext(); return Multiplicacion; }
( "/" )          { lexeme = yytext(); return Division; }
( "%" )          { lexeme = yytext(); return Modulo; }

/* Espacios en blanco */
{espacio}        {/* ignorar */}

/* Comentarios estilo C++ */
( "//"(.)* )     {/* ignorar */}

/* Salto de línea */
( "\n" )         { lexeme = yytext(); return Linea; }

/* Identificadores válidos */
{L}({L}|{D})*    { lexeme = yytext(); return Identificador; }

/* Números enteros positivos o negativos */
("-"?{D})        { lexeme = yytext(); return Numero; }

/* Cualquier otro carácter no reconocido */
.                { lexeme = yytext(); return ERROR; }
