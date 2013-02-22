package commande;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.text.SimpleDateFormat;

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
    public void commandesDansIntervalle(){
        //On ajoute la commande a la liste
        commande.sauvegarder();

        //On fait un mock de Intervalle
        Intervalle intervalle = mock(Intervalle.class);
        
        // Ici on fait un "stub"
        // Quand notre mock reçois la methode estCompris avec la valeur
        // de commande.date on renvois vrai.
        //
        // La méthode estCompris est testé dans IntervalleTest
        when(intervalle.estCompris(commande.date)).thenReturn(true);
        assertThat(Commande.obtenirCommandesDans(intervalle), hasItemInArray(commande));
    }

    @Test
    public void dansIntervalle(){
        Intervalle intervalle = mock(Intervalle.class);
        when(intervalle.estCompris(commande.date)).thenReturn(true);

        assertTrue(commande.estInclusDans(intervalle));
    }
}
