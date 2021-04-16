package citrine_challenge;

import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A Conversion object is a JSON object that contains two fields: unit_name and multiplication_factor, as specified in prompt.pdf.
 * 
 * @author lt
 *
 */
public class Conversion extends JSONObject {
    public Conversion(String stringSI, BigDecimal factor14sf) {
        try {
            this.put("unit_name", stringSI);
            this.put("multiplication_factor", factor14sf);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
