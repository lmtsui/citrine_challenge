package citrine_challenge;

import java.math.BigDecimal;
import java.math.MathContext;

public class WebServer {
    /**
     * 
     * 
     * @param units Properly formatted unit string, as defined in prompt.pdf
     * @return conversion Conversion object, as specified in prompt.pdf
     */
    public Conversion ConvertUnits(String units) {
        Expression expr = Expression.parse(units);
        String stringSI = expr.toStringSI();
        Double factor = expr.getFactor(); 
        BigDecimal bd = new BigDecimal(factor); // 14 sf
        BigDecimal factor14sf = bd.round(new MathContext(14));
        Conversion conversion = new Conversion(stringSI, factor14sf);
        return conversion;
    }

}
