grammar PL0;

// 语法规则：

//程序
program : program_header subprogram ;
//程序首部
program_header : PROGRAM identifier ;
//分程序
subprogram : constant_declaration? variable_declaration? statement ;
//常量说明
constant_declaration : CONST constant_definition (COMMA constant_definition)* SEMICOLON ;
//常量定义
constant_definition : identifier ASSIGN unsigned_integer ;
//无符号整数
unsigned_integer : INTEGER ;
//变量说明
variable_declaration : VAR identifier (COMMA identifier)* SEMICOLON ;
//标识符
identifier : IDENTIFIER ;
//复合语句
compound_statement : BEGIN statement (SEMICOLON statement)* END ;
//语句
statement : assignment_statement # AssignStatement
          | condition_statement  # ConditionStatement
          | loop_statement       # LoopStatement
          | compound_statement   # CompoundStatement
          | empty_statement      # EmptyStatement1
          ;
//赋值语句
assignment_statement : identifier ASSIGN expression ;

// 表达式
expression : add_sub? term               # ZhengFu
           | expression add_sub term     # JiaJian
           ;

// 项
term : factor                  # SingleFactor
     | term mul_div factor     # ChengChu
     ;


//因子
factor : identifier                       # Id
       | unsigned_integer                 # Int
       | LPAREN expression RPAREN         # Parens
       ;

//加减运算符
add_sub : ADD | SUB ;
//乘除运算符
mul_div : MUL | DIV ;
//条件语句
condition_statement : IF condition THEN statement ;
//循环语句
loop_statement : WHILE condition DO statement ;
//条件
condition : expression comparison_operator expression ;
//关系运算符
comparison_operator : EQUAL
                    | NOT_EQUAL
                    | LESS
                    | LESS_EQUAL
                    | GREATER
                    | GREATER_EQUAL ;
//空语句
empty_statement : ;




// 词法规则：
// 关键字
PROGRAM         : 'PROGRAM' ;
BEGIN           : 'BEGIN' ;
END             : 'END' ;
CONST           : 'CONST' ;
VAR             : 'VAR' ;
WHILE           : 'WHILE' ;
DO              : 'DO' ;
IF              : 'IF' ;
THEN            : 'THEN' ;

// 标识符
IDENTIFIER      : LETTER (LETTER | DIGIT)* ;
// 整数
INTEGER         : DIGIT+ ;

// 算符
ASSIGN          : ':=' ;
EQUAL           : '=' ;
NOT_EQUAL       : '<>' ;
GREATER         : '>' ;
GREATER_EQUAL   : '>=' ;
LESS            : '<' ;
LESS_EQUAL      : '<=' ;
MUL             : '*' ;
DIV             : '/' ;
ADD             : '+' ;
SUB             : '-' ;
LPAREN          : '(' ;
RPAREN          : ')' ;
SEMICOLON       : ';' ;
COMMA           : ',' ;

// 空白和换行，抛弃
WHITESPACE      : [ \t\r\n]+ -> skip ;

// 片段规则：
// 字母
fragment LETTER : [a-zA-Z] ;
// 数字
fragment DIGIT : [0-9] ;