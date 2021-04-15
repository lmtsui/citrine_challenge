package citrine_challenge;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AF(str) = Expression which is represented by str.
 * RI: True
 * Safety from rep exposure: all fields are private final immutable.
 * 
 * @author lt
 *
 */
public class Unit implements Expression {
    private final String str;
    private final Quantity quantity;
    
    public Unit(String str) {
        Quantity time = new Quantity("s", Map.of("minute",60.0,"hour",3600.0));
        Quantity planeAngle = new Quantity("rad", Map.of("degree",Math.PI/180,"arcminute",Math.PI/10800));
        Quantity area = new Quantity("m2", Map.of("hectare",10000.0));
        Quantity volume = new Quantity("m3", Map.of("litre",0.001));
        Quantity mass = new Quantity("kg", Map.of("tonne",1000.0));
        List<Quantity> allQuantities = List.of(time, planeAngle, area, volume, mass);
        for (Quantity q: allQuantities) {
            if (q.getNameSI().equals(str) || q.getNames().contains(str)) {
                this.str = str;
                this.quantity = q;
                return ;
            }
        }
        throw new RuntimeException("No quantity match");
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
