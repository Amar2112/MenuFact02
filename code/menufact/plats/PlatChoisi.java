package menufact.plats;

import menufact.facture.Facture;
import menufact.facture.FactureEtat;
import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatExceptions;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;
    private EtatDesPlats etatPlat;

    /***
     * Constructeur de PlatChoisi
     * @param plat
     * @param quantite
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        etat = new PlatPasCommande();
        etatPlat = EtatDesPlats.PASCOMMANDE;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat + " ,"+
                "etat du plat" + etat +
                '}';
    }

    /***
     *
     * @return la quantité de PlatAuMenu qui a été choisi par le client
     */
    public int getQuantite() {
        return quantite;
    }

    /***
     * Permet de rectifier la quantité de PlatAuMenu que le client a commandé
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /***
     *
     * @return le plat du menu choisi par le client.
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /***
     * Fonction qui change l'état du plat décrit sur la facture
     * @param facture
     */
    public void nextEtat(Facture facture) {

        try {
            etat = etat.setNextState(this,facture);
            etatPlat = etat.getEtatPlat();
        }catch(PlatExceptions e){
            e.printStackTrace();
        }

    }

    /***
     * Si les ingrédients pour faire le plat ne sont pas disponible, on met l'état de ce plat à PlatImpossible.
     */
    public void setEtatImpossible() {
        this.etat = new PlatImpossible();
    }

    /***
     * Si les ingrédients pour faire le plat ne sont pas disponible, on met l'état de ce plat à PlatImpossible.
     */
    public void setEtatDeBase() {
        this.etat = new PlatPasCommande();
    }

    /***
     * Permet de savoir quel est l'état actuel du plat.
     * @return l'état actuel du plat sous forme de classe.
     */
    public EtatPlat getEtat() {
        return etat;
    }

    /***
     * Constructeur de la classe
     * @return
     */
    public Plats createPlat(){
        return new PlatAuMenu();
    }

    /**
     * Retourne l'état du plat
     * @return l'état actuel du plat sous forme d'enum
     */
    public EtatDesPlats getEtatPlat() {
        return etatPlat;
    }
}

