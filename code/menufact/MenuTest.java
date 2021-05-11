package menufact;

import ingredients.*;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getInstance() {
        Menu menu = Menu.getInstance();
        Menu menu2 = Menu.getInstance();
        assertEquals(menu,menu2);
    }

    @Test
    void ajoute() throws MenuException {
        Ingredient pain = new Legume("Pain sauvage","Miam", EtatIngredient.SOLIDE);
        Ingredient beurre = new Laitier("Beurre savage","Bof",EtatIngredient.SOLIDE);
        IngredientInventaire b1 = new IngredientInventaire(beurre,2);
        IngredientInventaire p1 = new IngredientInventaire(pain,2);
        ArrayList<IngredientInventaire> array1= new ArrayList<>();
        array1.add(b1);
        array1.add(p1);
        Menu menu = Menu.getInstance();
        PlatAuMenu p = new PlatAuMenu(60,"plat",80,array1);
        PlatAuMenu p2 = p;
        menu.ajoute(p);
        menu.position(0);
        p2 = menu.platCourant();
        assertEquals(p2,p);
    }

    @Test
    void position() {
        Menu menu = Menu.getInstance();
        int i =5;
        menu.position(i);
        assertEquals(5,menu.getCourant());

    }

    @Test
    @BeforeEach
    void platCourant() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(65,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(66,"Pain doré",12.3);

        menu.ajoute(p0);
        menu.ajoute(p1);
        menu.position(0);
        assertEquals(menu.platCourant(),p0);
        menu.position(1);
        assertEquals(menu.platCourant(),p1);
    }

   
    @BeforeEach
    void positionSuivante() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(68,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        PlatAuMenu p2 = new PlatAuMenu(2,"Gauffre",11.45);

        menu.ajoute(p0);
        menu.ajoute(p1);
        menu.ajoute(p2);
        menu.positionSuivante();
        menu.positionSuivante();

        assertEquals(2,menu.getCourant());
    }


    @BeforeEach
    void positionPrecedente() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        menu.ajoute(p0);
        menu.ajoute(p1);
        menu.positionSuivante();
        menu.positionPrecedente();

        assertEquals(0,menu.getCourant());
    }


    @BeforeEach
    void afficherPlats() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        PlatAuMenu p2 = new PlatAuMenu();
        menu.ajoute(p0);
        menu.ajoute(p1);

        menu.afficherPlats();
    }


    @BeforeEach
    void afficherPlat() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        PlatAuMenu p2 = new PlatAuMenu();
        menu.ajoute(p0);
        menu.ajoute(p1);

        menu.afficherPlat(0);
        menu.afficherPlat(1);

    }


    @BeforeEach
    void getPlatAvecCode() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p3 = new PlatAuMenu();
        menu.ajoute(p0);
        p3 = menu.getPlatAvecCode(0);
        assertEquals(p3,p0);
    }


    @BeforeEach
    void getCourant() {
        Menu menu = Menu.getInstance();
        int j = menu.getCourant();
        assertEquals(0,j);
    }
}