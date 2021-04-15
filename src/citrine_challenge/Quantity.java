package citrine_challenge;

import java.util.Map;
import java.util.Set;

public class Quantity {
    
    private final Map<String,Double> nameToFactor;
    private final String nameSI;
    
    public Quantity(String nameSI, Map<String,Double> nameToFactor){
        this.nameSI = nameSI;
        this.nameToFactor = nameToFactor;       
    }
    public String getNameSI() {
        return nameSI;
    }
    public Map<String, Double> getNameToFactor() {
        return nameToFactor;
    }
    public Set<String> getNames() {
        return nameToFactor.keySet();
    }
}
