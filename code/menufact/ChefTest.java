package menufact;

import ingredients.*;
import inventaire.Inventaire;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import menufact.plats.exceptions.PlatExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class ChefTest {
    /**
     * Vide le menu à chaque fois qu'un méthode est appellée
     */
    @BeforeEach
    public void viderSingleton()
    {
        Menu m1 = Menu.getInstance();
        m1.viderMenu();
        Inventaire i1 = Inventaire.getInstance();
        i1.viderInventaire();
    }
    /**
     * Teste le bon fonctionnement de update
     * @throws PlatExceptions
     * @throws MenuException
     */
    @Test
    void update() throws PlatExceptions, MenuException {
        Menu menu = Menu.getInstance();

        Ingredient pain = new Legume("Pain","Miame", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bofe",EtatIngredient.SOLIDE);
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

        PlatEnfant Pe1 = new PlatEnfant(1,"Toasts",5.0,2,listePourPEToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);
        menu.ajoute(Pe1);
        EventManager em = new EventManager();
        Chef c = new Chef();
        em.engagerChef(c);
        Facture facture = new Facture("Facture de chef Test");
        facture.engagerDesChefs(em);
        try {
                facture.ajoutePlat(p);
        }
        catch(FactureException e){

        }
        catch (MenuException m){

        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }


        assertEquals(facture.getPlatchoisi().get(0).getEtatPlat(), EtatDesPlats.ENPREPARATION);
    }

    /**
     * Teste le bon fonctionnement d'attribuer un plat à un chef
     * @throws MenuException
     */
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


    /**
     * Teste le dernier état du plat, retourne l'exception de plat déjà servi
     * @throws MenuException
     */
    @Test
    void nextEtatPlatServi() throws MenuException {
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
        EventManager em = new EventManager();
        Chef c = new Chef();
        em.engagerChef(c);

        Facture facture = new Facture("Facture de chef Test");
        facture.engagerDesChefs(em);
        try{
            facture.ajoutePlat(p);
        }catch(FactureException f){
            f.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
    }

    /**
     * Regarde si on peut updater le plat après Impossible
     * @throws MenuException
     */
    @Test
    void nextEtatPlatImpossible() throws MenuException {
        Menu menu = Menu.getInstance();

        Ingredient pain = new Legume("Pain","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        IngredientInventaire b0 = new IngredientInventaire(beurre,5);
        IngredientInventaire p0 = new IngredientInventaire(pain,5);

        ArrayList<IngredientInventaire> listePourPEToast = new ArrayList();
        listePourPEToast.add(b1);
        listePourPEToast.add(p1);

        ArrayList<IngredientInventaire> listePourPToast = new ArrayList();
        listePourPToast.add(b1);
        listePourPToast.add(p1);

        Inventaire inventaire = Inventaire.getInstance();
        inventaire.ajouter(b0);
        inventaire.ajouter(p0);

        PlatEnfant Pe1 = new PlatEnfant(0,"Toasts",5.0,2,listePourPEToast);
        PlatAuMenu pm2 = new PlatAuMenu(1,"PresqueToast", 20, listePourPToast);
        PlatChoisi p = new PlatChoisi(Pe1,2);
        PlatChoisi p2 = new PlatChoisi(pm2, 2);
        menu.ajoute(Pe1);
        menu.ajoute(pm2);
        EventManager em = new EventManager();
        Chef c = new Chef();
        Chef c2 = new Chef();
        em.engagerChef(c);
        em.engagerChef(c2);

        Facture facture = new Facture("Facture de chef Test");
        facture.engagerDesChefs(em);
        try{
            facture.ajoutePlat(p);
            facture.ajoutePlat(p2);
        }catch(FactureException f){
            f.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
        try{
            c.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }

        try{
            c2.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }

        try{
            c2.update(facture);
        }catch(ChefException ce){
            ce.printStackTrace();
        }
    }
}