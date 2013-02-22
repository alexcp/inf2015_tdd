package commande;

import java.util.ArrayList;

public class RapportDeCommande {
    Commande[] commandes;

    public RapportDeCommande(Intervalle intervalle){
        this.commandes = obtenirCommandesDans(intervalle);
    }

    public int prixTotal(){
        int total = 0;
        for(Commande commande : commandes){
            total += commande.prix;
        }
        return total;
    }

    protected static Commande[] obtenirCommandesDans(Intervalle intervalle){
        ArrayList<Commande> commandes = new ArrayList<Commande>();

        for(Commande commande : Commande.all()){
            if(commande.estInclusDans(intervalle)){
                commandes.add(commande);
            }
        }

        return commandes.toArray(new Commande[commandes.size()]);
    }

}
