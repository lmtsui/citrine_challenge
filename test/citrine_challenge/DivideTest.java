package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DivideTest {

    @Test 
    void test() {
        Unit u1 = new Unit("hectare");
        Unit u2 = new Unit("hour");
        Divide d = new Divide(u1,u2);
        assertEquals(d.toString(),"hectare/hour");
        assertEquals(d.toStringSI(),"m^2/s");
        assertEquals(d.getFactor(),10000.0/3600);
    }

}
