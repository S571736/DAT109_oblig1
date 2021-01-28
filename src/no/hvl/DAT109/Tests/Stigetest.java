package no.hvl.DAT109.Tests;

import no.hvl.DAT109.Brett;
import no.hvl.DAT109.Terning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Sondre Lindaas Gjesdal
 * @author Sander Lyngbø
 * @date 28.01.2021
 */
public class Stigetest {
    Terning terning = new Terning();
    Brett brett = new Brett();

    @Test
    void trillTerning() {
        int min = 1;
        int max = 6;
        int trill;

        for (int i = 0; i < 100; i++) {
            trill = terning.trillTerning();
            assertTrue(min <= trill && trill <= max);

        }
    }

    @Test
    void getRuteVerdi(){
        assertEquals(10, brett.getRuteVerdi(2));
        assertEquals(0,brett.getRuteVerdi(0));
        assertEquals(-20, brett.getRuteVerdi(23));

    }
}
