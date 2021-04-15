package citrine_challenge;

import java.util.Map;

public class Time extends Unit {
    private final Map<String,Double> nameToFactor = Map.of("minute",60.0,"hour",3600.0);
    private final String nameSI = "s";
    private final double factor;

    public Time(String str) {
        super(str);
        this.factor = nameToFactor.get(str);
    }

    @Override public String toStringSI() {
        // TODO Auto-generated method stub
        return nameSI;
    }

    @Override public Double getFactor() {
        // TODO Auto-generated method stub
        return factor;
    }

}
