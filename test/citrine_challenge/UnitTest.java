package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class UnitTest {

    @Test 
    void test() {
        Unit expr = new Unit("minute");
        assertEquals(expr.toStringSI(),"s");
        assertEquals(expr.toString(),"minute");
        
        expr = new Unit("m2");
        assertEquals(expr.toStringSI(),"m2");
        assertEquals(expr.toString(),"m2");
        assertEquals(expr.getFactor(),1.0);
    }

}