package commande;

public class Intervalle {
    Object debut;
    Object fin;

    public Intervalle(Object debut, Object fin){
        this.debut = debut;
        this.fin = fin;
    }

    public boolean estCompris(Comparable object){
        return object.compareTo(debut) >= 0 && object.compareTo(fin) <= 0;
    }
}
