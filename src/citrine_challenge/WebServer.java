package citrine_challenge;

import java.math.BigDecimal;
import java.math.MathContext;

import org.json.simple.JSONObject;

public class WebServer {
    /**
     * 
     * 
     * @param input Properly formatted unit string, as defined in prompt.pdf
     * @return obj JSON object, as specified in prompt.pdf
     */
    public JSONObject ConvertUnits(String input) {
        Expression expr = Expression.parse(input);
        String stringSI = expr.toStringSI();
        Double factor = expr.getFactor(); 
        BigDecimal bd = new BigDecimal(factor); // 14 sf
        BigDecimal factor14sf = bd.round(new MathContext(14));
        JSONObject obj = new JSONObject();
        obj.put("unit_name", stringSI);
        obj.put("multiplication_factor", factor14sf);
        return obj;
    }

}
