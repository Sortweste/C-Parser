package lexer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLexer {

    private static int counter = 0;
    private static final Hashtable<Integer, Element> symbolTable = new Hashtable<>();
    private static final ArrayList<Token> tokens = new ArrayList<>();

    public static ArrayList<Token> lexer(String s){

        StringBuilder tokenPatternsBuffer = new StringBuilder();

        for(TokenType tokenType: TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));

        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(s);

        while (matcher.find()){

        }

        return tokens;
    }

}
