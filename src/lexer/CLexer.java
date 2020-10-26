package lexer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLexer {

    private static int counter = 0;
    //private static int line_count = 0;
    private static final Hashtable<Integer, Element> symbolTable = new Hashtable<>();
    private static final ArrayList<Token> tokens = new ArrayList<>();

    private static ArrayList<Token> lexer(String s){

        StringBuilder tokenPatternsBuffer = new StringBuilder();

        for(TokenType tokenType: TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));

        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(s);

        while (matcher.find()){
            if(matcher.group(TokenType.KEYWORDS.name()) != null){
                tokens.add(new Token(TokenType.KEYWORDS, matcher.group(TokenType.KEYWORDS.name())));
            }else if(matcher.group(TokenType.CONDITIONAL.name()) != null){
                tokens.add(new Token(TokenType.CONDITIONAL, matcher.group(TokenType.CONDITIONAL.name())));
            }else if(matcher.group(TokenType.LOOPTYPE.name()) != null){
                tokens.add(new Token(TokenType.LOOPTYPE, matcher.group(TokenType.LOOPTYPE.name())));
            }else if(matcher.group(TokenType.DATATYPE.name()) != null){
                tokens.add(new Token(TokenType.DATATYPE, matcher.group(TokenType.DATATYPE.name())));
            }else if(matcher.group(TokenType.STRUCTYPE.name()) != null){
                tokens.add(new Token(TokenType.STRUCTYPE, matcher.group(TokenType.STRUCTYPE.name())));
            }else if(matcher.group(TokenType.IDENTIFIER.name()) != null){
                tokens.add(new Token(TokenType.IDENTIFIER, matcher.group(TokenType.IDENTIFIER.name())));
            }else if(matcher.group(TokenType.NUMBERTYPE.name()) != null){
                tokens.add(new Token(TokenType.NUMBERTYPE, matcher.group(TokenType.NUMBERTYPE.name())));
            }else if(matcher.group(TokenType.OPERATOR.name()) != null){
                tokens.add(new Token(TokenType.OPERATOR, matcher.group(TokenType.OPERATOR.name())));
            }else if(matcher.group(TokenType.ASSIGNATION.name()) != null){
                tokens.add(new Token(TokenType.ASSIGNATION, matcher.group(TokenType.ASSIGNATION.name())));
            }else if(matcher.group(TokenType.ENDINSTRUCTION.name()) != null){
                tokens.add(new Token(TokenType.ENDINSTRUCTION, matcher.group(TokenType.ENDINSTRUCTION.name())));
            }else if(matcher.group(TokenType.OPENBRACKET.name()) != null){
                tokens.add(new Token(TokenType.OPENBRACKET, matcher.group(TokenType.OPENBRACKET.name())));
            }else if(matcher.group(TokenType.CLOSEBRACKET.name()) != null){
                tokens.add(new Token(TokenType.CLOSEBRACKET, matcher.group(TokenType.CLOSEBRACKET.name())));
            }else if(matcher.group(TokenType.OPENPARENTHESIS.name()) != null){
                tokens.add(new Token(TokenType.OPENPARENTHESIS, matcher.group(TokenType.OPENPARENTHESIS.name())));
            }else if(matcher.group(TokenType.CLOSEPARENTHESIS.name()) != null){
                tokens.add(new Token(TokenType.CLOSEPARENTHESIS, matcher.group(TokenType.CLOSEPARENTHESIS.name())));
            }
        }
        return tokens;
    }

    private static void addTokenToHashTable(String s){
        lexer(s);
        for(Token token: tokens){
            symbolTable.put(counter, new Element());
            counter++;
        }
    }

    public static void printTokens(){
        for(Token token: tokens)
            System.out.println(token);
    }

    public static void printHashTable(){
        System.out.printf("\n%s \t %s \t %s \t %s \t %s \t %s%n", "TOKEN_TYPE", "NAME", "DATATYPE", "VARIABLE", "FUNCTION", "VALUE");
        symbolTable.forEach((integer, element) -> System.out.println(element));
    }

}
