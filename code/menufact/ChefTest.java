package menufact;

import ingredients.*;
import inventaire.Inventaire;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import menufact.plats.exceptions.PlatExceptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {

    @Test
    void update() throws PlatExceptions, MenuException {
        Menu menu = Menu.getInstance();

        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,50);
        IngredientInventaire p0 = new IngredientInventaire(pain,100);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);


        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatEnfant Pe1 = new PlatEnfant(0,"Toasts",5.0,2,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);
        menu.ajoute(Pe1);
        Chef c;
        Facture facture = new Facture("Facture de chef Test");

        try {
                facture.ajoutePlat(p);
        }
        catch(FactureException e){
            e.printStackTrace();
        }
        catch (MenuException m){
            m.printStackTrace();
        }
        p.nextEtat(facture);
    }

    @Test
    void attribuerPlat() throws MenuException {
        Menu menu = Menu.getInstance();

        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,50);
        IngredientInventaire p0 = new IngredientInventaire(pain,100);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);


        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatEnfant Pe1 = new PlatEnfant(0,"Toasts",5.0,2,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);
        menu.ajoute(Pe1);
        Chef c = new Chef();
        Facture facture = new Facture("Facture de chef Test");

        c.attribuerPlat(p,facture);

    }
}