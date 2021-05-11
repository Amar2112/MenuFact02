package menufact.facture;

import ingredients.*;
import inventaire.Inventaire;
import menufact.Client;
import menufact.EventManager;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    @Test
    void associerClient() {
        Client c1 = new Client(9, "Georges","292929");
        Facture facture1 = new Facture("facture");
        facture1.associerClient(c1);
        assertEquals(c1,facture1.getClient());
    }

    @Test
    void getEtat() {
        Facture facture1 = new Facture("facture");
        assertEquals(facture1.getEtat(), FactureEtat.OUVERTE);
    }

    @Test
    void ajoutePlatPasAuMenu() {
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

        PlatEnfant pe1 = new PlatEnfant(0,"Toasts",5.0,2,listePourPEToast);
        PlatAuMenu pm1 = new PlatAuMenu(1,"ToastNorm",20,listePourPEToast);
        PlatChoisi p = new PlatChoisi(pe1,2);

        Facture facture = new Facture("Ma facture");
        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pm1);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            facture.ajoutePlat(p);
        }catch(FactureException e){
            e.printStackTrace();
        }
        catch (MenuException m){
            assertTrue(m.getMessage().contains("MenuException: Le code n'est pas dans le menu"));
        }
    }
    @Test
    void testAjoutePlatFerme() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        f.fermer();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
    }


    @Test
    void testAjoutePlatPaye() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        f.payer();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
    }
    @Test
    void testGenereFacturePayee() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
        Client c1 = new Client(9, "Georges","292929");


        f.payer();
        f.associerClient(c1);

        try{
            System.out.println(f.genererFacture());
        }catch (FactureException fe)
        {
            fe.printStackTrace();
        }
    }

    @Test
    void testGenereFactureOuverte() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
        Client c1 = new Client(9, "Georges","292929");

        f.associerClient(c1);

        try{
            System.out.println(f.genererFacture());
        }catch (FactureException fe)
        {
            fe.printStackTrace();
        }
    }
    @Test
    void testGenereFactureFermee() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
        Client c1 = new Client(9, "Georges","292929");


        f.fermer();
        f.associerClient(c1);

        try{
            System.out.println(f.genererFacture());
        }catch (FactureException fe)
        {
            fe.printStackTrace();
        }
    }


    @Test
    void testAjoutePlat() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
        fe.printStackTrace();
        }
        PlatChoisi p = f.getPlatchoisi().get(0);

        assertEquals(p,f.getPlatchoisi().get(0));
    }

    @Test
    void TestOuvrirUneFactureFermee()
    {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            assertTrue(fe.getMessage().contains("FactureException: La facture doit être ouverte pour ajouter un plat"));
        }
        Client c1 = new Client(9, "Georges","292929");


        f.fermer();

        try{
            f.ouvrir();
        }catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    @Test
    void TestOuvrirUneFacturePayee()
    {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        Client c1 = new Client(9, "Georges","292929");


        f.payer();

        try{
            f.ouvrir();
        }catch(FactureException fe){
           assertTrue(fe.getMessage().contains("FactureException: La facture est à l'etat payee, il est impossible de l'ouvrir"));
        }
    }
    @Test
    void enleverPlat() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
        try {
            f.enleverPlat(pc0.getQuantite());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }



    @Test
    void changerQuantitePlat() {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            f.ajoutePlat(pc0);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
        try {
            f.changerQuantitePlat(pc0.getPlat().getCode(), 8);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(8,pc0.getQuantite());
    }

    @Test
    void testToString() {
    }

    @Test
    void genererFacture() {

    }

    @Test
    void genererFactureSansClient() {
       Facture f1 = new Facture("allo");
        try{
           f1.genererFacture();
        }catch(FactureException e){
            assertEquals(e.getMessage(), "FactureException: Il n'y a pas de client assigné à la facture");
        }
    }
    @Test
    void getPlatchoisi() throws FactureException,MenuException {
        Facture f = new Facture("Test");
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

        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();
        try{
            menu.ajoute(pe0);
        }catch(MenuException m){
            m.printStackTrace();
        }


        f.ajoutePlat(pc0);
        PlatChoisi p = f.getPlatchoisi().get(0);

        assertEquals(p,f.getPlatchoisi().get(0));
    }

    @Test
    void getDescription() {
        Facture f = new Facture("Test");
        assertEquals("Test",f.getDescription());
    }

    @Test
    void getCourant() {
        Facture f = new Facture("Test");
        assertEquals(-1,f.getCourant());

    }

    @Test
    void getClient() {
        Facture f = new Facture("Test");
        Client c = f.getClient();
        assertEquals(c,f.getClient());
    }

    @Test
    void getEM() {
        Facture f = new Facture("Test");
        EventManager e = f.getEM();
        assertEquals(e, f.getEM());
    }
}