package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import org.junit.jupiter.api.Test;

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
        Menu menu = Menu.getInstance();
        PlatAuMenu p = new PlatAuMenu();
        PlatAuMenu p2 = new PlatAuMenu();
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
    void platCourant() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);

        menu.ajoute(p0);
        menu.ajoute(p1);
        menu.position(0);
        assertEquals(menu.platCourant(),p0);
        menu.position(1);
        assertEquals(menu.platCourant(),p1);
    }

    @Test
    void positionSuivante() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        PlatAuMenu p2 = new PlatAuMenu(2,"Gauffre",11.45);

        menu.ajoute(p0);
        menu.ajoute(p1);
        menu.ajoute(p2);
        menu.positionSuivante();
        menu.positionSuivante();

        assertEquals(2,menu.getCourant());
    }

    @Test
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

    @Test
    void afficherPlats() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p1 = new PlatAuMenu(1,"Pain doré",12.3);
        PlatAuMenu p2 = new PlatAuMenu();
        menu.ajoute(p0);
        menu.ajoute(p1);

        menu.afficherPlats();
    }

    @Test
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

    @Test
    void getPlatAvecCode() throws MenuException {
        Menu menu = Menu.getInstance();
        PlatAuMenu p0 = new PlatAuMenu(0,"Crêpes",10.5);
        PlatAuMenu p3 = new PlatAuMenu();
        menu.ajoute(p0);
        p3 = menu.getPlatAvecCode(0);
        assertEquals(p3,p0);
    }

    @Test
    void getCourant() {
        Menu menu = Menu.getInstance();
        int j = menu.getCourant();
        assertEquals(0,j);
    }
}