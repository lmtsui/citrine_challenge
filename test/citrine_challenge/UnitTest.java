package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class UnitTest {

    @Test 
    void test() {
        Unit expr = new Unit("minute");
        assertEquals(expr.toStringSI(),"s");
        assertEquals(expr.toString(),"minute");
        
        expr = new Unit("m^2");
        assertEquals(expr.toStringSI(),"m^2");
        assertEquals(expr.toString(),"m^2");
        assertEquals(expr.getFactor(),1.0);
        
        expr = new Unit("ha");
        assertEquals(expr.toStringSI(),"m^2");
        assertEquals(expr.toString(),"hectare");
        assertEquals(expr.getFactor(),10000.0);
    }

}