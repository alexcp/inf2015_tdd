package commande;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Date;

public class CommandeTest {
    Commande commande;

    public CommandeTest() {
    }

    @Before
    public void before(){
        Date date = mock(Date.class);
        commande = new Commande(10,date);
        Commande.viderListe();
    }

    @Test
    public void constructeur() {
        assertThat(commande,is(instanceOf(Commande.class)));
    }

    @Test
    public void listeDeCommande(){
        assertThat(Commande.all(),emptyArray());
    }

    @Test
    public void sauvegarder(){
         commande.sauvegarder();
         assertThat(Commande.all(), hasItemInArray(commande));
    }

    @Test
    public void genererIdentifiant(){
        assertThat(commande.genererIdentifiant(), notNullValue());
    }

    @Test
    public void viderListeDeCommande(){
        commande.sauvegarder();
        Commande.viderListe();
        assertThat(Commande.all(),emptyArray());
    }

    @Test
    public void dansIntervalle(){
        // Ici on fait un "stub"
        // Quand notre mock reçois la methode estCompris avec la valeur
        // de commande.date on renvois vrai.
        //
        // La méthode estCompris est testé dans IntervalleTest
        Intervalle intervalle = mock(Intervalle.class);
        when(intervalle.estCompris(commande.date)).thenReturn(true);

        assertTrue(commande.estInclusDans(intervalle));
    }
}
