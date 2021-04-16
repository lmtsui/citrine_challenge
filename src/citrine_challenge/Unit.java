package citrine_challenge;

/**
 * AF(str, quantity) = Expression which is represented by str.
 * RI: str is either the SI name, a quantity name, or a quantity symbol 
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public class Unit implements Expression {
    private final String str;
    private final Quantity quantity;
    
    public Unit(String str) {
        for (Quantity q: PresetQuantities.allQuantities) {
            if (q.getNameSI().equals(str) || q.getNames().contains(str) || q.getSyms().contains(str)) {
                this.str = q.getSyms().contains(str)? q.getSymToName().get(str) : str; //converts quantity symbol to name if needed
                this.quantity = q;
                return ;
            }
        }
        throw new RuntimeException("Should not reach here. No quantity match");
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
    
    @Override 
    public Double getFactor() {
        if (str.equals(quantity.getNameSI())) {
            return 1.0;
        }else {
            return quantity.getNameToFactor().get(str);
        }
        
    }

    public String toStringSI() {
        return quantity.getNameSI();
    }
}