package citrine_challenge;


/**
 * AF(str) = Expression which is represented by str.
 * RI: True
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public abstract class Unit implements Expression {
    private final String str;
    
    public Unit(String str) {
        this.str = str;
    }
    
    @Override
    public String toString() {
        return str;
    }
    @Override
    public boolean equals(Object that){
        return (that instanceof Unit) && str.equals(((Unit)that).toString());
    }
    @Override
    public int hashCode(){
        return str.hashCode();
    }
    
    public abstract String toStringSI();
    
    public abstract Double getFactor();
}
