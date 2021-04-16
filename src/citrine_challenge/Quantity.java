package citrine_challenge;

import java.util.Map;
import java.util.Set;

/**
 * Assumes nameSI is not in the keys of nameToFactor
 * 
 * @author lt
 *
 */
public class Quantity {
    
    private final Map<String,Double> nameToFactor;
    private final Map<String,String> symToName;
    private final String nameSI;
    
    public Quantity(String nameSI, Map<String,Double> nameToFactor, Map<String,String> symToName){
        this.nameSI = nameSI;
        this.nameToFactor = nameToFactor;
        this.symToName = symToName;    
    }
    public String getNameSI() {
        return nameSI;
    }
    public Map<String, Double> getNameToFactor() {
        return nameToFactor;
    }
    public Map<String, String> getSymToName() {
        return symToName;
    }
    public Set<String> getNames() {
        return nameToFactor.keySet();
    }
    public Set<String> getSyms() {
        return symToName.keySet();
    }
}
