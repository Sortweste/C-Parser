package lexer;

public class Token {

    private final TokenType tokenType;
    private final String data;

    public Token(TokenType tokenType, String data){
        this.tokenType = tokenType;
        this.data = data;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", tokenType.name(), data);
    }

}