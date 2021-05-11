package menufact;
import ingredients.*;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatCommande;
import menufact.plats.PlatImpossible;

public class Chef
{
    PlatChoisi p1;

    /***
     * Permet de changer l'état du plat de la facture
     * @param facture
     */
    public void update(Facture facture)
    {
        p1.nextEtat(facture);
    }

    /***
     * Permet d'attribuer un plat au chef
     * @param p
     * @param facture
     */
    public void attribuerPlat(PlatChoisi p, Facture facture)
    {
        p1 = p;
    }
}
