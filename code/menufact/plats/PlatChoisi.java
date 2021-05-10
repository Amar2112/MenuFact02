package menufact.plats;

import menufact.facture.FactureEtat;
import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatExceptions;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private EtatPlat etat;

    public PlatChoisi(PlatAuMenu plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
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

    public void nextEtat() {

        try {
            etat = etat.setNextState();
        }catch(PlatExceptions e)
        {
            e.printStackTrace();
        }
    }

    public void setEtat(){ this.etat = new PlatCommande();}

    public void setEtatImpossible() {
        this.etat = new PlatImpossible();
    }

    public EtatPlat getEtat() {
        return etat;
    }
}
