package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class ExpressionTest {

    @Test void test() {
        Expression e = Expression.parse("m2");
        Unit u = new Unit("m2");
        assertEquals(e,u);
//        assertEquals(PresetQuantities.getAllNames().toString(),"[s, hour, rad, m2, m3, degree, litre, hectare, kg, tonne, arcminute, minute]");
        e = Expression.parse("((hectare))");
        assertEquals(e.getFactor(),10000.0);
        e = Expression.parse("((hectare)/litre)");
        assertEquals(e.getFactor(),10000.0/0.001);
        assertEquals(e.toStringSI(),"((m2)/m3)");
        e = Expression.parse("(day*(hectare)/litre)");
        assertEquals(e.getFactor(),(86400*10000.0)/0.001);
        assertEquals(e.toStringSI(),"(s*(m2)/m3)");
    }

}
