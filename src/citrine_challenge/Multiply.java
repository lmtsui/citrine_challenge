package citrine_challenge;


/**
 * AF(left, right) = Expression which is represented by left*right.
 * RI: True
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public class Multiply implements Expression{
    private final Expression left;
    private final Expression right;
    
    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    public Expression getLeft() {
        return left;
    }
    
    public Expression getRight() {
        return right;
    }
    
    @Override
    public String toString() {
        return left.toString() + "*" + right.toString();
    }
    @Override
    public boolean equals(Object that){
        if (! (that instanceof Multiply)) return false;
        return ((Multiply)that).getLeft().equals(left) && ((Multiply)that).getRight().equals(right);
    }
    @Override
    public int hashCode(){
        return left.hashCode() + right.hashCode();
    }
    
    public String toStringSI(){
        return left.toStringSI() + "*" + right.toStringSI();
    }
    
    public Double getFactor(){
        return left.getFactor() * right.getFactor();
    }
}
