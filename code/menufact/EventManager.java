package menufact;
import menufact.Chef;
import menufact.facture.Facture;
import menufact.plats.EtatDesPlats;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class EventManager {
    ArrayList<Chef> chefs = new ArrayList<Chef>();
    public EventManager(){

    }

    /**
     * Ajoute un nouveau chef à la liste des chefs
     * @param c un nouveau chef
     */
    public void engagerChef(Chef c)
    {
        if(c == null){

        }else {
            chefs.add(c);
        }
    }

    /**
     * Notifie tous les chefs de la cuisine qui n'ont pas déjà un plat d'assigné
     */
    public void notifierChefs(PlatChoisi p, Facture facture) throws ChefException{
        boolean chefNotifie = false;
        if(chefs.isEmpty() == true){
            throw new ChefException("Aucun chef ne peut être appele");
        }
        for(Chef c : chefs){
            if(chefNotifie == false) {
                if (c.getPlat() == null) {
                    c.attribuerPlat(p, facture);
                    chefNotifie = true;
                } else if (c.getPlat().getEtatPlat() == EtatDesPlats.IMPOSSIBLE) {
                    c.attribuerPlat(p, facture);
                    chefNotifie = true;
                }
            }
        }
        if(chefNotifie == false){
            throw new ChefException("Aucun chef ne peut reçevoir la commande");
        }

    }
}
