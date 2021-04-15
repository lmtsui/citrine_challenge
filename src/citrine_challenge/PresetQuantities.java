package citrine_challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PresetQuantities {
    static final  Quantity time = new Quantity("s", Map.of("minute",60.0,"hour",3600.0,"day",86400.0));
    static final  Quantity planeAngle = new Quantity("rad", Map.of("degree",Math.PI/180,"arcminute",Math.PI/10800));
    static final  Quantity area = new Quantity("m2", Map.of("hectare",10000.0));
    static final  Quantity volume = new Quantity("m3", Map.of("litre",0.001));
    static final  Quantity mass = new Quantity("kg", Map.of("tonne",1000.0));
    static final List<Quantity> allQuantities = List.of(time, planeAngle, area, volume, mass);
    public static Set<String> getAllNames(){
        Set<String> allNames = new HashSet<String>();
        for (Quantity q: allQuantities) {
            allNames.add(q.getNameSI());
            allNames.addAll(q.getNames());
        }
        return allNames;
    }
}
