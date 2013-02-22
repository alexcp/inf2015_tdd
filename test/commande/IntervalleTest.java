package commande;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class IntervalleTest {
    Intervalle intervalle;

    public IntervalleTest() {
    }

    @Before
    public void constructeur() throws Exception{
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        Date debut = dateParser.parse("2013-02-10");
        Date fin = dateParser.parse("2013-02-20");

        intervalle = new Intervalle(debut,fin);
    }

    @Test
    public void estCompris() throws Exception{
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateParser.parse("2013-02-15");

        assertTrue(intervalle.estCompris(date));
    }
}
