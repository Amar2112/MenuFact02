package inventaire;


import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @Test
    void getLesIngredients() {
        Inventaire inv = Inventaire.getInstance();
    }

    @Test
    void getInstance() {
        Inventaire inv = Inventaire.getInstance();
        assertEquals(inv,Inventaire.getInstance());
    }

    @Test
    void ajouter() throws InventaireException {
        Ingredient fraise = new Fruit("Fraise","Miam", EtatIngredient.SOLIDE);
        IngredientInventaire ingInv = new IngredientInventaire(fraise,200);
        Inventaire inv = Inventaire.getInstance();
        inv.ajouter(ingInv);
        ArrayList<IngredientInventaire> lesIngredients;
        lesIngredients = inv.getLesIngredients();
        assertTrue(ingInv.getIngredient().compare(lesIngredients.get(inv.indexIngredient(ingInv)).getIngredient()));
        assertEquals(ingInv.getQuantite(),lesIngredients.get(inv.indexIngredient(ingInv)).getQuantite() );
    }

    @Test
    void indexIngredientPasInventaire()
    {
        Ingredient fraise = new Fruit("Fraise","Miam", EtatIngredient.SOLIDE);
        Viande viandeRouge1 = new Viande("viande","viande rouge",EtatIngredient.SOLIDE);
        IngredientInventaire ingInv = new IngredientInventaire(fraise,200);
        IngredientInventaire ingInvViande = new IngredientInventaire(viandeRouge1, 300);
        Inventaire inv = Inventaire.getInstance();
        inv.ajouter(ingInv);
        try{
            inv.indexIngredient(ingInvViande);
        }catch(InventaireException e){
            assertEquals(e.getMessage(), "L'ingredient " + ingInvViande + " ne se trouve pas dans l'inventaire");
        }
    }

    @Test
    void indexIngredient() throws InventaireException {
        Ingredient fraise = new Fruit("Fraise","Miam", EtatIngredient.SOLIDE);
        Ingredient poire = new Fruit("Poire","Yum",EtatIngredient.SOLIDE);
        IngredientInventaire ingInv = new IngredientInventaire(fraise,200);
        IngredientInventaire ingInv2 = new IngredientInventaire(poire,300);
        Inventaire inv = Inventaire.getInstance();
        inv.ajouter(ingInv);
        int i = inv.indexIngredient(ingInv);
        assertEquals(2,i);
    }

    @Test
    void isDisponible() throws InventaireException, IngredientException {
        Ingredient pain = new Legume("Pain","Miam",EtatIngredient.SOLIDE);
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

        assertTrue(inventaire.isDisponible(p));
    }

    @Test
    void isDisponibleFaux() {
        Ingredient pain = new Legume("Pain","Miam",EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,1);
        IngredientInventaire p0 = new IngredientInventaire(pain,1);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatAuMenu Pe1 = new PlatAuMenu(0,"Toasts",20,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);

        try
        {
            assertTrue(inventaire.isDisponible(p));
        }catch(InventaireException e)
        {
            assertTrue(e.getMessage().contains("L'inventaire n'a pas assez de " + b1));
        }
    }

    @Test
    void rectifierInventaire() throws InventaireException, IngredientException {
        Ingredient pain = new Legume("Pain","Miam",EtatIngredient.SOLIDE);
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


        assertTrue(inventaire.rectifierInventaire(p));
    }

    @Test
    void rectifierInventaireAZero() throws InventaireException, IngredientException {
        Ingredient pain = new Legume("Pain","Miam",EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,4);
        IngredientInventaire p0 = new IngredientInventaire(pain,4);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatSante Pe1 = new PlatSante(0,"Toast santé", 40,2,1,2,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);


        assertTrue(inventaire.rectifierInventaire(p));
    }
    @Test
    void rectifierInventaireANegatif() {
        Ingredient pain = new Legume("Pain","Miam",EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,4);
        IngredientInventaire p0 = new IngredientInventaire(pain,4);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatEnfant Pe1 = new PlatEnfant(0,"Toasts",5.0,2,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,3);

        try{
            assertTrue(inventaire.rectifierInventaire(p));
        }
        catch(InventaireException i){
            assertTrue(i.getMessage().contains("L'inventaire n'a pas assez de " + b1));
        }
        catch (IngredientException e){

        }

    }
    @Test
    void testToString() {

        Inventaire inventaire = Inventaire.getInstance();
        String s = inventaire.toString();
        assertEquals(s,inventaire.toString());
    }
}