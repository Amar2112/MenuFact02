package menufact;

import menufact.plats.EtatPlat;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatCommande;
import menufact.plats.PlatEnfant;
import menufact.plats.exceptions.PlatExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void update() throws PlatExceptions {
        Chef c;
        PlatEnfant pe1 = new PlatEnfant();
        PlatChoisi p1 = new PlatChoisi(pe1,2);


        if(p1 != null)
        {
                p1.nextEtat();
                assertEquals(EtatPlat.class,p1.getEtat());
        }
        else if(p1 == null)
        {
            p1.setEtat();
            assertEquals(PlatCommande.class,p1.getEtat());
        }

    }

    @Test
    void attribuerPlat() {
    }
}