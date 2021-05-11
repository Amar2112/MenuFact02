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

    public void update(Facture facture)
    {
        p1.nextEtat(facture);
    }
    public void attribuerPlat(PlatChoisi p, Facture facture)
    {
        p1 = p;
        //update(facture);
    }
}
