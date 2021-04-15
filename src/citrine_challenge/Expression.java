package citrine_challenge;


/**
 * An immutable data type representing an unit expression.
 * 
 * @author lt
 *
 */
public interface Expression {
    // Data type definition
    //   Expression = Unit(String input)
    //                + Multiply(Expression left, Expression right)
    //                + Divide(Expression num, Expression denum)
    //                + Bracket(Expression expr)
    
    /**
     * Parse an expression.
     * @param input expression to parse
     * @return expression AST for the input
     * @throws RuntimeException if the expression is syntactically invalid.
     */
    public static Expression parse(String input){
        try {
            return ExpressionParser.parse(input);
        } catch (UnableToParseException e) {
            throw new RuntimeException("the expression has a syntax error", e);
        }
    }
    
    /**
     * @return str a parsable representation of this expression, such that
     *         for all e:Expression, e.equals(Expression.parse(e.toString()))
     */
    @Override 
    public String toString();

    /**
     * @param that any object
     * @return true if and only if this and that are structurally-equal
     *         Expressions
     */
    @Override
    public boolean equals(Object that);
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     *         equality, such that for all e1,e2:Expression,
     *             e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode();
    
    /**
     * @return str string representation of this expression in SI units
     */
    public String toStringSI();
    
    /**
     * @return x Multiplication factor for which expression = x * expression in SI units
     */
    public Double getFactor();
}
