package lexer;

public enum TokenType {

    MULTILINECOMMENTS("\\/\\*(.|[\\r\\n])*?\\*\\/");

    public final String pattern;

    TokenType(String pattern) {
        this.pattern = pattern;
    }

}
