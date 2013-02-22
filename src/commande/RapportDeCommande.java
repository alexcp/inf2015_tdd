package commande;

public class RapportDeCommande {
    Commande[] commandes;

    public RapportDeCommande(Intervalle intervalle){
        this.commandes = Commande.obtenirCommandesDans(intervalle);
    }
}
