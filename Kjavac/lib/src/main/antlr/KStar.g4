grammar KStar;
@header {
}

file                    : (declaration)* ;

// Any type of declaration that can be made in the file scope
declaration             : function_declaration
                        | class_declaration
                        | WS
                        ;


class_declaration       : WS? visibility WS ((KW_ENUM | KW_SINGLETON) WS)? KW_CLASS WS type WS (KW_EXTENDS WS type WS)? (KW_IMPLEMENTS WS (type WS? COMMA WS)* type WS?)? L_SCOPE WS? R_SCOPE ;


function_signature      : WS? visibility WS type WS ID L_PAREN WS? ((decl WS? COMMA WS?)* decl)? WS? R_PAREN WS? ;
function_declaration    : function_signature L_SCOPE statement_list R_SCOPE
                        | function_signature STATEMENT_END
                        ;

visibility              : KW_PUBLIC 
                        | KW_PRIVATE
                        ;

// Represents a block of code
statement_list          : (WS? statement WS? STATEMENT_END WS?)* ;

statement               : decl_assign 
                        | assign
                        | decl
                        | expr
                        ;

decl_assign             : type WS assign ;
assign                  : ID WS? EQUAL WS? expr ;
decl                    : type WS ID ;

type                    : KW_VOID
                        | KW_INT
                        | KW_UINT
                        | ID
                        ;


expr                    :   expr WS? (MULTIPLY|DIVIDE) WS? expr
                        |   expr WS? (ADD|SUBTRACT) WS? expr
                        |   DEC_LIT
                        |   HEX_LIT
                        |   BIN_LIT
                        |   L_PAREN WS? expr WS? R_PAREN
                        |   ID
                        ;

// Whitespace
WS              : [\r\n\t ]+ ;

// Math
EQUAL           : '=' ;
MULTIPLY        : '*' ;
DIVIDE          : '/' ;
ADD             : '+' ;
SUBTRACT        : '-' ;

// Parenthesis
L_PAREN         : '(' ;
R_PAREN         : ')' ;
L_SCOPE         : '{' ;
R_SCOPE         : '}' ;

// Punctuation
STATEMENT_END   : ';' ;
COMMA           : ',' ;

// Keywords
KW_PUBLIC       : 'public' ;
KW_PRIVATE      : 'private' ;
KW_CLASS        : 'class' ;
KW_EXTENDS      : 'extends' ;
KW_IMPLEMENTS   : 'implements' ;
KW_ENUM         : 'enum' ;
KW_SINGLETON    : 'singleton' ;

// Builtin types
KW_VOID         : 'void' ;
KW_INT          : 'int' ;
KW_UINT         : 'uint' ;

// Literals
DEC_LIT         : [0-9]+('.'[0-9]+)? ;
HEX_LIT         : '0x'[0-9a-fA-F]+ ;
BIN_LIT         : '0b'[0-1]+ ;

// Identifier
ID              : [a-zA-Z$_] [a-zA-Z0-9$_]* ;