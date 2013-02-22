package commande;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class RapportDeCommandeTest {

    public RapportDeCommandeTest() {
    }

    @Test
    public void nouveauRapport() {
        Intervalle intervalle = mock(Intervalle.class);

        RapportDeCommande rapport = new RapportDeCommande(intervalle);
        assertThat(rapport, is(instanceOf(RapportDeCommande.class)));
    }
}
