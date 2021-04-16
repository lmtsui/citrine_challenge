package citrine_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BracketTest {

    @Test void test() {
        Unit u = new Unit("ha");
        Bracket b = new Bracket(u);
        assertEquals(b.toString(),"(hectare)");
        assertEquals(b.toStringSI(),"(m^2)");
    }

}
