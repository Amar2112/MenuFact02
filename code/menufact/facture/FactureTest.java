package menufact.facture;

import menufact.Client;
import menufact.EventManager;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class FactureTest {

    @Test
    void associerClient() {
    }

    @Test
    void sousTotal() {

    }

    @Test
    void total() {
    }

    @Test
    void getEtat() {
    }

    @Test
    void ajoutePlat() {
    }

    @Test
    void testAjoutePlat() {
    }

    @Test
    void changerQuantitePlat() {
    }

    @Test
    void enleverPlat() {
    }

    @Test
    void testToString() {
    }

    @Test
    void genererFacture() {

    }

    @Test
    void getPlatchoisi() throws FactureException {
        Facture f = new Facture("Test");
        PlatEnfant pe0 = new PlatEnfant(0,"Crepes",12.0,0.75);
        PlatChoisi p0 = new PlatChoisi(pe0,2);
        f.ajoutePlat(p0);
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