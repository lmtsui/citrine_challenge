package citrine_challenge;

/**
 * AF(inner) = Expression which is represented by (inner).
 * RI: True
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public class Bracket implements Expression{
    private final Expression inner;
    
    public Bracket(Expression inner) {
        this.inner = inner;
    }
    
    public Expression getInner() {
        return inner;
    }
    
    @Override
    public String toString() {
        return "(" + inner.toString() + ")";
    }
    @Override
    public boolean equals(Object that){
        if (! (that instanceof Bracket)) return false;
        return ((Bracket)that).getInner().equals(inner);
    }
    @Override
    public int hashCode(){
        return inner.hashCode();
    }
    
    public String toStringSI(){
        return "(" + inner.toStringSI() + ")";
    }
    
    public Double getFactor(){
        return inner.getFactor();
    }
}
