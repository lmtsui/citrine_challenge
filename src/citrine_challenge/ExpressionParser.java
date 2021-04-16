package citrine_challenge;


public class ExpressionParser {

    /**
     * Parse an expression.
     * @param input expression to parse
     * @return expression AST for the input
     * @throws UnableToParseException if the expression is syntactically invalid.
     */
    static Expression parse(String input) throws UnableToParseException {
        if (PresetQuantities.getAllNames().contains(input)) {
            return new Unit(input);
        }else {
            int l = input.length();
            if (l==0) {
                throw new UnableToParseException("input is empty");
            }
            int height = 0; //number of brackets enclosing position i
            boolean isBracket = true; //whether the whole input is enclosed in a pair of brackets
            for (int i=l-1; i>=0; i--) { //decreasing i, so * and / operators without brackets are evaluated from left to right
                if (input.charAt(i)==')') {
                    height += 1;
                }
                if (input.charAt(i)=='(') {
                    height -= 1;
                }
                if (height==0 && i>0) {
                    isBracket = false;
                }
                if (height<0) {
                    throw new UnableToParseException("Brackets not balanced");
                }
                //System.out.println("input: "+input+" height: "+height+" i: "+i);
                if (height==0) {
                    if (input.charAt(i)=='*') {
                        Expression left = Expression.parse(input.substring(0,i));
                        Expression right = Expression.parse(input.substring(i+1));
                        return new Multiply(left, right);
                    }
                    if (input.charAt(i)=='/') {
                        Expression num = Expression.parse(input.substring(0,i));
                        Expression denum = Expression.parse(input.substring(i+1));
                        return new Divide(num, denum);
                    }
                }
            }
            if (height!=0) {
                throw new UnableToParseException("Brackets not balanced in total");
            }
            if (isBracket) {
                Expression inner = Expression.parse(input.substring(1, l-1));
                return new Bracket(inner);
            }
            throw new UnableToParseException("Cannot Parse input: "+input);
        }
    }

}
