package menufact.plats;
import ingredients.*;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.EventManager;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PlatChoisiTest {
    /**
     * Vide le menu à chaque fois qu'un méthode est appellée
     */
    @BeforeEach
    public void viderMenu()
    {
        Menu m1 = Menu.getInstance();
        m1.viderMenu();
    }
    /**
     * Teste getQuantite
     */
    @Test
    public void getQuantite() {
        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        PlatAuMenu toast = new PlatAuMenu(0,"Toast", 20,listePourPEToast);
        PlatChoisi p = new PlatChoisi(toast, 2);
        assertEquals(2, p.getQuantite());

    }

    /**
     * Teste le bon fonctionnement de setQuantite
     */
    @Test
    public void setQuantite() {
        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        PlatAuMenu toast = new PlatAuMenu(0,"Toast", 20,listePourPEToast);
        PlatChoisi p = new PlatChoisi(toast, 2);
        p.setQuantite(9);
        assertEquals(9, p.getQuantite());
    }

    /**
     * Teste le bon fonctionnement de getEtat
     */
    @Test
    public void getEtat() {
        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        PlatAuMenu toast = new PlatAuMenu(0,"Toast", 20,listePourPEToast);
        PlatChoisi p = new PlatChoisi(toast, 2);

        assertEquals(EtatDesPlats.PASCOMMANDE, p.getEtatPlat());
    }
}
