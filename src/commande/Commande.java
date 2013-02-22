package commande;
import java.util.Date;
import java.util.ArrayList;

public class Commande {
    Date date;
    int prix;
    static ArrayList<Commande> listeDesCommande = new ArrayList<Commande>();

    public static Commande[] all(){
        return listeDesCommande.toArray(new Commande[listeDesCommande.size()]);
    }

    public static void viderListe(){
        listeDesCommande.clear();
    }

    public Commande(int prix, Date date){
        this.date = date;
        this.prix = prix;
    }

    public boolean sauvegarder(){
        listeDesCommande.add(this);
        return true;
    }

    public int genererIdentifiant(){
        Date date = new Date();
        return date.hashCode();
    }

    public boolean estInclusDans(Intervalle intervalle){
        return intervalle.estCompris(date);
    }
}
