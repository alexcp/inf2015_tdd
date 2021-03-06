package commande;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Date;

public class RapportDeCommandeTest {
    RapportDeCommande rapport;

    public RapportDeCommandeTest() {
    }

    @Before
    public void nouveauRapport() {
        Intervalle intervalle = mock(Intervalle.class);

        rapport = new RapportDeCommande(intervalle);
        assertThat(rapport, is(instanceOf(RapportDeCommande.class)));
    }

    @Test
    public void commandesDansIntervalle(){
        //On ajoute la commande a la liste
        Commande commande = new Commande(10,mock(Date.class));
        commande.sauvegarder();

        //On fait un mock de Intervalle
        Intervalle intervalle = mock(Intervalle.class);
        
        // Ici on fait un "stub"
        // Quand notre mock reçois la methode estCompris avec la valeur
        // de commande.date on renvois vrai.
        //
        // La méthode estCompris est testé dans IntervalleTest
        when(intervalle.estCompris(commande.date)).thenReturn(true);
        assertThat(RapportDeCommande.obtenirCommandesDans(intervalle), hasItemInArray(commande));
    }


    @Test
    public void prixTotal() {
        // je n'aime pas trop ce test, mais avec la façon que Java fonctionne
        // on ne peu pas Stubber des methode static
        Commande commande1 = new Commande(10,mock(Date.class));
        Commande commande2 = new Commande(10,mock(Date.class));

        Commande.viderListe();
        commande1.sauvegarder();
        commande2.sauvegarder();

        Intervalle intervalle = mock(Intervalle.class);
        when(intervalle.estCompris(commande1.date)).thenReturn(true);
        when(intervalle.estCompris(commande2.date)).thenReturn(true);
        
        RapportDeCommande rapport = new RapportDeCommande(intervalle);
        assertThat(rapport.prixTotal(), is(20));
    }
}
