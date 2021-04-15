package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class MultiplyTest {

    @Test 
    void test() {
        Unit u1 = new Unit("minute");
        Unit u2 = new Unit("degree");
        Multiply m = new Multiply(u1,u2);
        assertEquals(m.toString(),"minute*degree");
        assertEquals(m.toStringSI(),"s*rad");
        assertEquals(m.getFactor(),Math.PI/180*60);
    }

}