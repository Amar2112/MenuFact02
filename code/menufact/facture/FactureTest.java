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

    /**
     * Teduste l'sssociation  client à la facture
     */
    @Test
    void associerClient() {
        Client c1 = new Client(9, "Georges","292929");
        Facture facture1 = new Facture("facture");
        facture1.associerClient(c1);
        assertEquals(c1,facture1.getClient());
    }

    /**
     * Teste le bon fonctionnement getEtat
     */
    @Test
    void getEtat() {
        Facture facture1 = new Facture("facture");
        assertEquals(facture1.getEtat(), FactureEtat.OUVERTE);
    }

    /**
     * Essaie d'ajouter un plat pas présent dans le menu
     */
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

    /**
     * Essai d'ajouter un plat lorsque le plat est fermé
     */
    @Test
    void testAjoutePlatFerme() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Pain magique","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre magique","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(46,"Crepes",12.0,0.75, listePourPEToast);
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

    /**
     * Essai d'ajouter un plat lorsqu'il est payé
     */
    @Test
    void testAjoutePlatPaye() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Carotte blanche","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre noir","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(45,"Crepes",12.0,0.75, listePourPEToast);
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

    /**
     * Genere la facture d'une facture fermée
     */
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

    /**
     * Génère la facture ouverte
     */
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

    /**
     * Génère la facture fermée
     */
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

    /**
     * Ajoute un plat d'une facture ouverte
     */
    @Test
    void testAjoutePlat() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Pain vicieux","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre vicieux","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(59,"Crepes",12.0,0.75, listePourPEToast);
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

    /**
     * Essai d'ouvrir une facture fermée
     */
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
        }
        Client c1 = new Client(9, "Georges","292929");


        f.fermer();

        try{
            f.ouvrir();
        }catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(f.getEtat(), FactureEtat.OUVERTE);
    }

    /**
     * Essai d'ouvrir une facture payée
     */
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

    /**
     * Teste le bon fonctionnement d'enleverPlat
     */
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
            f.enleverPlat(pc0.getPlat().getCode());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    /**
     * Enlève un plat qui n'est pas dans la liste
     */
    @Test
    void enleverPlatPasDansLaListe() {
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
        PlatEnfant pe1 = new PlatEnfant(1,"Gateau",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }

        try {
            menu.ajoute(pe1);
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
            f.enleverPlat(pe1.getCode());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    /**
     * Enlève un plat qui n'est pas au menu
     */
    @Test
    void enleverPlatPasAuMenu() {
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
        PlatEnfant pe1 = new PlatEnfant(1,"Gateau",12.0,0.75, listePourPEToast);
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
            f.enleverPlat(pe1.getCode());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    /**
     * Essai d'enlever un plat lorsque la facture est fermée
     */
    @Test
    void enleverPlatFerme() {
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
        f.fermer();
        try {
            f.enleverPlat(pc0.getPlat().getCode());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    /**
     * Essai d'enlever plat lorsque la facture est payée
     */
    @Test
    void enleverPlatPayee() {
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
        f.payer();
        try {
            f.enleverPlat(pc0.getPlat().getCode());

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }
    }

    /**
     * Tester le bon fonctionnement de changerQuantitePlat
     */
    @Test
    void changerQuantitePlat() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Pain Delice","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre malice","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(50,"Crepes",12.0,0.75, listePourPEToast);
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

        assertEquals(8,f.getPlatchoisi().get(0).getQuantite());
    }

    /**
     * Essai de changer la quantite du plat qui n'est pas dans le menu
     */
    @Test
    void changerQuantitePlatPasPresentDansLeMenu() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Pain miraculeux","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre miraculeux","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(51,"Crepes",12.0,0.75, listePourPEToast);
        PlatEnfant pe1 = new PlatEnfant(52,"Gateau",12.0,0.75, listePourPEToast);
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
            f.changerQuantitePlat(pe1.getCode(), 8);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(2,f.getPlatchoisi().get(0).getQuantite());
    }

    /**
     * Essai de changer la quantite du plat qui n'est pas présent dans la liste
     */
    @Test
    void changerQuantitePlatPasPresentListe() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Carotte naine","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Lait d'acajou","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(43,"Crepes",12.0,0.75, listePourPEToast);
        PlatEnfant pe1 = new PlatEnfant(44,"Gateau",12.0,0.75, listePourPEToast);
        PlatChoisi pc0 = new PlatChoisi(pe0,2);

        Menu menu = Menu.getInstance();

        try {
            menu.ajoute(pe0);
        }catch (MenuException m){
            m.printStackTrace();
        }
        try {
            menu.ajoute(pe1);
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
            f.changerQuantitePlat(pe1.getCode(), 8);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(2,f.getPlatchoisi().get(0).getQuantite());
    }

    /**
     * Essai de changer la quantité du plat lorsque la facture est fermée
     */
    @Test
    void changerQuantitePlatFerme() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Patate","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Yougourt","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(10,"Crepes",12.0,0.75, listePourPEToast);
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
        f.fermer();
        try {
            f.changerQuantitePlat(pc0.getPlat().getCode(), 8);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(2,f.getPlatchoisi().get(0).getQuantite());
    }

    /**
     * Changer la quantité du plat lorsque la facture est payée
     */
    @Test
    void changerQuantitePlatPayer() {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Carotte","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Lait","Bof",EtatIngredient.LIQUIDE);
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

        PlatEnfant pe0 = new PlatEnfant(21,"Crepes",12.0,0.75, listePourPEToast);
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
        f.payer();
        try {
            f.changerQuantitePlat(pc0.getPlat().getCode(), 8);

        }catch (MenuException m){
            m.printStackTrace();
        }
        catch(FactureException fe){
            fe.printStackTrace();
        }

        assertEquals(2,f.getPlatchoisi().get(0).getQuantite());
    }

    /**
     * Essai de générer une facture sans client associé
     */
    @Test
    void genererFactureSansClient() {
       Facture f1 = new Facture("allo");
        try{
           f1.genererFacture();
        }catch(FactureException e){
            assertEquals(e.getMessage(), "FactureException: Il n'y a pas de client assigné à la facture");
        }
    }

    /**
     * Teste le bon fonctionnement de getPlatChoisi
     * @throws FactureException
     * @throws MenuException
     */
    @Test
    void getPlatchoisi() throws FactureException,MenuException {
        Facture f = new Facture("Test");
        Ingredient pain = new Legume("Patate douce","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Fromage de chevre","Bof",EtatIngredient.SOLIDE);
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

        PlatEnfant pe0 = new PlatEnfant(13,"Crepes",12.0,0.75, listePourPEToast);
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

    /**
     * Teste le bon fonctionnement de getDescription
     */
    @Test
    void getDescription() {
        Facture f = new Facture("Test");
        assertEquals("Test",f.getDescription());
    }

    /**
     * Teste le bon fonctionnnement de getCourant
     */
    @Test
    void getCourant() {
        Facture f = new Facture("Test");
        assertEquals(-1,f.getCourant());

    }

    /**
     * Teste le bon fonctionnement de getClient
     */
    @Test
    void getClient() {
        Facture f = new Facture("Test");
        Client c = f.getClient();
        assertEquals(c,f.getClient());
    }
    /**
     * Teste le bon fonctionnement de getEM
     */
    @Test
    void getEM() {
        Facture f = new Facture("Test");
        EventManager e = f.getEM();
        assertEquals(e, f.getEM());
    }
}