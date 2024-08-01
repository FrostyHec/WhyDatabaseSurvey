grammar BasicSql;
//默认所有英文输入都会在这里被转换成大写，不区分大小写
paragraphs
    : singleStatement (';' singleStatement)* EOF
    ;
singleStatement
    : statement (';')?
    ;
statement
    :CREATE TABLE table '('+ columns = colTypeList+')' #createTable
    |INSERT INTO table ('(' + columns = colList +')')? VALUES '('+vals+')'#insertTable
    |DROP table #dropTable
    |UPDATE table SET valAssignTypeList (WHERE boolExpression)? #updateTable
    |SELECT selectField FROM table (WHERE boolExpression)? #selectTable
    ;
selectField
    :STAR
    ;
table:ID;
boolExpression
    : '(' boolExpression ')'
    | operator=NOT bool1Expr=boolExpression
    | bool1Expr=boolExpression (operator=(AND|OR) bool2Expr=boolExpression)+
    | fieldName=ID operator=LIKE regex=VALSTRING
    | left=valExpression operator=(GREATER|LESS|EQUALS|DOUBLEEQUALS|GREATEREQUAS|LESSEQUALS) right=valExpression
    ;
valExpression
    : '(' valExpression ')'
    | primaryValExpression
    | left=valExpression operator=(STAR|DIVIDED) right=valExpression
    | left=valExpression operator=(ADD|SUBTRACT) right=valExpression
    ;

primaryValExpression
    : ID
    | valType
    ;
valAssignTypeList
    : valAssignType (',' valAssignType)*
    ;

valAssignType
    : ID '=' valType
    ;

vals
    : valType (',' valType)*
    ;


valType
    : numberType
    | VALSTRING
    | NULL
    | functions
    ;
functions
    : 'replace('field=ID ',' origin=VALSTRING ',' new=VALSTRING ')' #replaceFunction
    ;
numberType: op=('+'|'-')? unsignednumbType;
unsignednumbType
    : VALINT
    | VALDOUBLE
    ;

colTypeList
    : colType (',' colType)*
    ;
colList
    : ID (',' ID)*
    ;
colType
    : ID type=dataType PRIMARY_KEY?
    ;

dataType
    : INTTYPE
    | DOUBLETYPE
    | STRINGTYPE
    ;

//关键字
CREATE: C R E A T E;
TABLE: T A B L E;
INSERT: I N S E R T;
INTO: I N T O;
VALUES: V A L U E S;
DROP: D R O P;
SET: S E T;
UPDATE: U P D A T E;
WHERE:W H E R E;
FROM: F R O M;
SELECT: S E L E C T;
PRIMARY_KEY:P R I M A R Y '_' K E Y;

INTTYPE: I N T ;
DOUBLETYPE: D O U B L E;
STRINGTYPE: S T R I N G;

NOT: N O T|'!';
AND: A N D|'&'|'&&';
OR: O R|'|'|'||';
ADD: '+';
SUBTRACT: '-';
DIVIDED: '/';
GREATER: '>';
LESS: '<';
EQUALS: '=';
DOUBLEEQUALS: '==';
LIKE: L I K E;
STAR: '*';//both * and allField
GREATEREQUAS: '>=';
LESSEQUALS: '<=';

NULL: N U L L;
ID : [a-zA-Z][a-zA-Z0-9_]*;//标识符名称大小写敏感
VALINT:[0-9]+;
VALDOUBLE: VALINT+'.'+VALINT;
VALSTRING: DOUBLESTR | SINGLESTR ;
fragment DOUBLESTR: '"' ('""'|~["])* '"' ;
fragment SINGLESTR: '\'' ('\'\''|~['])* '\'' ;

WS: [ \t\r\n]+ -> skip; // 忽略空格和制表符
COMMENT: '#' .*?  -> skip;

//大小写不敏感Matcher
fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];