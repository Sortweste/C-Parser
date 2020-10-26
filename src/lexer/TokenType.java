package lexer;

public enum TokenType {

    COMMENTS("\\/\\*(.|[\\r\\n])*?\\*\\/"),
    KEYWORDS("(return)|(void)"),
    CONDITIONAL("(if)|(else)"),
    LOOPTYPE("(do)|(while)|(for)"),
    DATATYPE("(int)|(char)|(float)"),
    STRUCTYPE("struct"),
    IDENTIFIER("([a-zA-Z_])([a-zA-Z_]|[0-9])*"),
    NUMBERTYPE("\\d+"),
    OPERATOR("\\+|\\-|\\*|\\/|\\%"),
    //LOGICOPERATOR("\\<|\\>|"),
    ASSIGNATION("\\="),
    ENDINSTRUCTION("\\;"),
    OPENBRACKET("\\{"),
    CLOSEBRACKET("\\}"),
    OPENPARENTHESIS("\\("),
    CLOSEPARENTHESIS("\\)"),
    WHITESPACE("\\s+");

    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

}
