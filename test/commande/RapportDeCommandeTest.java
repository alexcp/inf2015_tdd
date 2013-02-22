package commande;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Date;

public class RapportDeCommandeTest {

    public RapportDeCommandeTest() {
    }

    @Test
    public void nouveauRapport() {
        Date debut = mock(Date.class);
        Date fin = mock(Date.class);

        RapportDeCommande rapport = new RapportDeCommande(debut,fin);
        assertThat(rapport, is(instanceOf(RapportDeCommande.class)));
    }
}
