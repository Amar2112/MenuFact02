package menufact;
import menufact.Chef;
import menufact.facture.Facture;
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
        chefs.add(c);
    }

    /**
     * Notifie tous les chefs de la cuisine
     */
    public void notifierChefs(PlatChoisi p, Facture facture){
        for(Chef c : chefs){
            c.attribuerPlat(p, facture);
        }
    }
}
