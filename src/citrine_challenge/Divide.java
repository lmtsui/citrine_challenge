package citrine_challenge;

/**
 * AF(num, denum) = Expression which is represented by num/denum.
 * RI: True
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public class Divide implements Expression{
    private final Expression num;
    private final Expression denum;
    
    public Divide(Expression num, Expression denum) {
        this.num = num;
        this.denum = denum;
    }
    public Expression getNum() {
        return num;
    }
    
    public Expression getDenum() {
        return denum;
    }
    
    @Override
    public String toString() {
        return num.toString() + "/" + denum.toString();
    }
    @Override
    public boolean equals(Object that){
        if (! (that instanceof Divide)) return false;
        return ((Divide)that).getNum().equals(num) && ((Divide)that).getDenum().equals(denum);
    }
    @Override
    public int hashCode(){
        return num.hashCode() + denum.hashCode();
    }
    
    public String toStringSI(){
        return num.toStringSI() + "/" + denum.toStringSI();
    }
    
    public Double getFactor(){
        return num.getFactor() / denum.getFactor();
    }
}
