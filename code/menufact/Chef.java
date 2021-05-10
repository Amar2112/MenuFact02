package menufact;
import ingredients.*;
import inventaire.Inventaire;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatCommande;
import menufact.plats.PlatImpossible;

public class Chef
{
    PlatChoisi p1;

    public void update()
    {
        if(p1 != null)
        {
            p1.nextEtat();
        }
    }
    public void attribuerPlat(PlatChoisi p)
    {
        p1 = p;
        update();
    }
}
