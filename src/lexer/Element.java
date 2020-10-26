package lexer;

public class Element {

    private final String token_type;
    private final String name;
    private final String datatype;
    private final boolean variable;
    private final boolean function;
    private final String value;
    private final int line_number;
    private final String scope;

    public Element(String token_type, String name, String datatype, boolean variable, boolean function, String value, int line_number, String scope){
        this.token_type = token_type;
        this.name = name;
        this.datatype = datatype;
        this.variable = variable;
        this.function = function;
        this.value = value;
        this.line_number = line_number;
        this.scope = scope;
    }

    @Override
    public String toString(){
        return String.format("%s \t %s \t %s \t %s \t %s \t %s \t %s \t %s", token_type, name, datatype, variable, function, value, line_number, scope);
    }

}