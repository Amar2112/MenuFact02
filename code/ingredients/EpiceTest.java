package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpiceTest {

    @Test
    void getEtat() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals("Poudre d'ail", e.getNom());
    }

    @Test
    void setNom() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setNom("Ail rôti");
        assertEquals("Ail rôti", e.getNom());
    }

    @Test
    void getDescription() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals("C'est bon", e.getDescription());
    }

    @Test
    void setDescription() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.EPICE, e.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setTypeIngredient(TypeIngredient.FRUIT);
        assertEquals(TypeIngredient.FRUIT,e.getTypeIngredient());
    }

    @Test
    void compare() {
        Epice x = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        Epice y = new Epice("Vinaigre Balsamique","C'est bof",EtatIngredient.LIQUIDE);

        assertFalse(x.compare(y));
        assertTrue(x.compare(e));


    }
}