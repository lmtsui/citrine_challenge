package citrine_challenge;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AF(str, quantity) = Expression which is represented by str.
 * RI: str is in quantity.getNames() or str.equals(quantity.getNameSI())
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
            if (q.getNameSI().equals(str) || q.getNames().contains(str)) {
                this.str = str;
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
