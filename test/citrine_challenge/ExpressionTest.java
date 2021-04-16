package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class ExpressionTest {

    @Test void test() {
        Expression e = Expression.parse("m^2");
        Unit u = new Unit("m^2");
        assertEquals(e,u);
//        assertEquals(PresetQuantities.getAllNames().toString(),
//                "[\", d, m2, m3, ', h, degree, litre, hectare, L, minute, °, s, min, hour, rad, t, ha, kg, tonne, day, arcminute, arcsecond]");
        
        e = Expression.parse("((hectare))");
        assertEquals(e.getFactor(),10000.0);
        assertEquals(e, Expression.parse(e.toString()));
        
        e = Expression.parse("((hectare)/litre)");
        assertEquals(e.getFactor(),10000.0/0.001);
        assertEquals(e.toStringSI(),"((m^2)/m^3)");
        assertEquals(e, Expression.parse(e.toString()));
        
        e = Expression.parse("(day*(hectare)/litre)");
        assertEquals(e.getFactor(),(86400*10000.0)/0.001);
        assertEquals(e.toStringSI(),"(s*(m^2)/m^3)");
        assertEquals(e, Expression.parse(e.toString()));
        
        
        
        e = Expression.parse("(s/minute)");
        assertEquals(e, Expression.parse(e.toString()));
        assertEquals(e.toStringSI(), "(s/s)");
        assertEquals(e.getFactor(), 1.0/60);
        
    }
    @Test void testGiven() {
        
        Expression e = Expression.parse("degree");
        assertEquals(e, Expression.parse(e.toString()));
        assertEquals(e.toStringSI(), "rad");
        assertEquals(e.getFactor(), Math.PI/180);
        
        e = Expression.parse("(degree/minute)");
        assertEquals(e, Expression.parse(e.toString()));
        assertEquals(e.toStringSI(), "(rad/s)");
        assertEquals(e.getFactor(),Math.PI/180/60);
        
        e = Expression.parse("(degree/(minute*hectare))");
        assertEquals(e, Expression.parse(e.toString()));
        assertEquals(e.toStringSI(), "(rad/(s*m^2))");
        assertEquals(e.getFactor(), Math.PI/180/(60*10000));
        
        e = Expression.parse("ha*°");
        assertEquals(e, Expression.parse(e.toString()));
        assertEquals(e.toStringSI(), "m^2*rad");
        assertEquals(e.getFactor(), 10000*Math.PI/180);
    }
    
    @Test void testExceptions() {
        assertThrows(UnableToParseException.class, ()->{Expression e = ExpressionParser.parse("");});
        
        assertThrows(RuntimeException.class, ()->{Expression e = Expression.parse("");});
        
        assertThrows(UnableToParseException.class, ()->{Expression e = ExpressionParser.parse("(degree))");});
        
        assertThrows(UnableToParseException.class, ()->{Expression e = ExpressionParser.parse("((degree)");});
        
        assertThrows(UnableToParseException.class, ()->{Expression e = ExpressionParser.parse("abc");});
        
        assertThrows(UnableToParseException.class, ()->{Expression e = ExpressionParser.parse("(s))((s)");});
    }
}
