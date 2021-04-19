package citrine_challenge;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PresetQuantities {
    static final Quantity time = new Quantity("s", Map.of("minute",60.0,  "hour",3600.0,  "day",86400.0),
                                                   Map.of("min", "minute",  "h", "hour",  "d", "day"));
    
    static final Quantity planeAngle = new Quantity("rad", Map.of("degree",Math.PI/180,  "arcminute",Math.PI/10800,  "arcsecond",Math.PI/648000),
                                                           Map.of("°", "degree",  "'", "arcminute",  "\"", "arcsecond"));
    
    static final Quantity area = new Quantity("m^2", Map.of("hectare",10000.0), Map.of("ha", "hectare"));
    
    static final Quantity volume = new Quantity("m^3", Map.of("litre",0.001), Map.of("L", "litre"));
    
    static final Quantity mass = new Quantity("kg", Map.of("tonne",1000.0), Map.of("t", "tonne"));
    
    static final List<Quantity> allQuantities = List.of(time, planeAngle, area, volume, mass);
    static final Set<String> allNames = new HashSet<String>();
    private static boolean init = false;
    public static Set<String> getAllNames(){
        if (!init) {
            for (Quantity q: allQuantities) {
                allNames.add(q.getNameSI());
                allNames.addAll(q.getNames());
                allNames.addAll(q.getSyms());
            }
            init = true;
        }
        return allNames;
    }
}
