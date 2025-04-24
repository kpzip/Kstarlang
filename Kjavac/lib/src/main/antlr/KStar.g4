grammar KStar;
@header {
}

file                    : (declaration)* ;

// Any type of declaration that can be made in the file scope
declaration             : function_declaration
                        | class_declaration
                        ;


class_declaration       : visibility (KW_ENUM | KW_SINGLETON)? KW_CLASS type (KW_EXTENDS type)? (KW_IMPLEMENTS (type COMMA)* type)? L_SCOPE R_SCOPE ;


function_signature      : visibility type ID L_PAREN ((decl COMMA)* decl)? R_PAREN ;
function_declaration    : function_signature L_SCOPE statement_list R_SCOPE
                        | function_signature STATEMENT_END
                        ;

visibility              : KW_PUBLIC 
                        | KW_PRIVATE
                        ;

// Represents a block of code
statement_list          : (WS? statement STATEMENT_END)* ;

statement               : decl_assign 
                        | assign
                        | decl
                        | expr
                        ;

decl_assign             : type assign ;
assign                  : ID EQUAL expr ;
decl                    : type ID ;

type                    : KW_VOID
                        | KW_INT
                        | KW_UINT
                        | ID
                        ;


expr                    :   expr (MULTIPLY|DIVIDE) expr
                        |   expr (ADD|SUBTRACT) expr
                        |   DEC_LIT
                        |   HEX_LIT
                        |   BIN_LIT
                        |   L_PAREN expr R_PAREN
                        |   ID
                        ;

// Whitespace
WS                   : [\r\n\t ]+ -> channel(HIDDEN) ;

// Comments
LINE_COMMENT         : '//' ~[\r\n]* -> channel(HIDDEN) ;
MULTILINE_COMMENT    : '/*' .*? '*/' -> channel(HIDDEN) ;

// Math
EQUAL                : '=' ;
MULTIPLY             : '*' ;
DIVIDE               : '/' ;
ADD                  : '+' ;
SUBTRACT             : '-' ;

// Parenthesis
L_PAREN              : '(' ;
R_PAREN              : ')' ;
L_SCOPE              : '{' ;
R_SCOPE              : '}' ;

// Punctuation
STATEMENT_END        : ';' ;
COMMA                : ',' ;

// Keywords
KW_PUBLIC            : 'public' ;
KW_PRIVATE           : 'private' ;
KW_CLASS             : 'class' ;
KW_EXTENDS           : 'extends' ;
KW_IMPLEMENTS        : 'implements' ;
KW_ENUM              : 'enum' ;
KW_SINGLETON         : 'singleton' ;
KW_MUT               : 'mut' ;

// Builtin types
KW_VOID              : 'void' ;
KW_INT               : 'int' ;
KW_UINT              : 'uint' ;

// Literals
DEC_LIT              : [0-9]+('.'[0-9]+)? ;
HEX_LIT              : '0x'[0-9a-fA-F]+ ;
BIN_LIT              : '0b'[0-1]+ ;

// Identifier
ID                   : [a-zA-Z$_] [a-zA-Z0-9$_]* ;