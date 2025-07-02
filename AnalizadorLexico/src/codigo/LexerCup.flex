package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

L=[a-z]
D=[0-9]+
espacio=[ \t\r\n]+

%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Palabras reservadas */
INI          { return symbol(sym.INI, yytext()); }
FIN          { return symbol(sym.FIN, yytext()); }
REPEAT       { return symbol(sym.REPEAT, yytext()); }
CHECK        { return symbol(sym.CHECK, yytext()); }
INTER        { return symbol(sym.INTER, yytext()); }
PRINT        { return symbol(sym.PRINT, yytext()); }
ELSE         { return symbol(sym.ELSE, yytext()); }
WHILE        { return symbol(sym.WHILE, yytext()); }
FOR          { return symbol(sym.FOR, yytext()); }
FUNCTION     { return symbol(sym.FUNCTION, yytext()); }
RETURN       { return symbol(sym.RETURN, yytext()); }
INT          { return symbol(sym.INT, yytext()); }
LANG         { return symbol(sym.LANG, yytext()); }
ARRAY        { return symbol(sym.ARRAY, yytext()); }

/* Símbolos compuestos */
"=="         { return symbol(sym.Igual_Comparacion, yytext()); }
"!="         { return symbol(sym.Diferente, yytext()); }
"<="         { return symbol(sym.Menor_Igual, yytext()); }
">="         { return symbol(sym.Mayor_Igual, yytext()); }
"&&"         { return symbol(sym.AND, yytext()); }
"||"         { return symbol(sym.OR, yytext()); }

/* Símbolos simples */
"{"          { return symbol(sym.Llave_Apertura, yytext()); }
"}"          { return symbol(sym.Llave_Cierre, yytext()); }
"("          { return symbol(sym.Parentesis_A, yytext()); }
")"          { return symbol(sym.Parentesis_C, yytext()); }
","          { return symbol(sym.Coma, yytext()); }
";"          { return symbol(sym.PuntoYComa, yytext()); }
"="          { return symbol(sym.Igual, yytext()); }
"<"          { return symbol(sym.Menor, yytext()); }
">"          { return symbol(sym.Mayor, yytext()); }
"+"          { return symbol(sym.Suma, yytext()); }
"-"          { return symbol(sym.Resta, yytext()); }
"*"          { return symbol(sym.Multiplicacion, yytext()); }
"/"          { return symbol(sym.Division, yytext()); }
"%"          { return symbol(sym.Modulo, yytext()); }

/* Ignorar espacios, saltos y comentarios */
{espacio}     { /* ignorar */ }
"//".*        { /* ignorar */ }

/* Identificadores y números */
{L}({L}|{D})* { return symbol(sym.Identificador, yytext()); }
("-")?{D}     { return symbol(sym.Numero, yytext()); }

/* Caracteres ilegales */
.             { return symbol(sym.ERROR, yytext()); }
