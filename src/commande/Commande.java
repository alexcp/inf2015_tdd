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

    public static Commande[] obtenirCommandesDansIntervalle(Date debut, Date fin){
        ArrayList<Commande> commandes = new ArrayList<Commande>();

        for(Commande commande : listeDesCommande){
            if(commande.dansIntervalle(debut, fin)){
                commandes.add(commande);
            }
        }

        return commandes.toArray(new Commande[commandes.size()]);
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

    public boolean dansIntervalle(Date debut, Date fin){
        return date.compareTo(debut) >= 0 && date.compareTo(fin) <= 0;
    }

}
