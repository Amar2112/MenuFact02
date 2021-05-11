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

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
        etat = new PlatPasCommande();
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat + " ,"+
                "etat du plat" + etat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }

    public void nextEtat(Facture facture) {

        try {
            etat = etat.setNextState(this,facture);
            etatPlat = etat.getEtatPlat();
        }catch(PlatExceptions e){
            e.printStackTrace();
        }

    }

    public void setEtat(){ this.etat = new PlatPasCommande();}

    public void setEtatImpossible() {
        this.etat = new PlatImpossible();
    }

    public EtatPlat getEtat() {
        return etat;
    }

    public Plats createPlat(){
        return new PlatAuMenu();
    }

    public EtatDesPlats getEtatPlat() {
        return etatPlat;
    }
}

