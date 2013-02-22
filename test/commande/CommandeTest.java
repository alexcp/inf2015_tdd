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
    public void commandeDansIntervalle() throws Exception{
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        Date debut = dateParser.parse("2013-02-10");
        Date fin = dateParser.parse("2013-02-20");

        Commande.obtenirCommandesDansIntervalle(debut, fin);
    }

    @Test
    public void dansIntervalle() throws Exception{
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        Date debut = dateParser.parse("2013-02-10");
        Date fin = dateParser.parse("2013-02-20");

        Commande commande = new Commande(10,dateParser.parse("2013-02-15"));
        assertTrue(commande.dansIntervalle(debut,fin));
    }
}
