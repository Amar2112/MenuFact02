package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegumeTest {

    @Test
    void getEtat() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals("Cocombre", e.getNom());
    }

    @Test
    void setNom() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setNom("Poivron");
        assertEquals("Poivron", e.getNom());
    }

    @Test
    void getDescription() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals("Crunchy", e.getDescription());
    }

    @Test
    void setDescription() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setDescription("Franchement crunchy");
        assertEquals("Franchement crunchy", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.LEGUME, e.getTypeIngredient());
    }

    @Test
    void compare() {
        Legume carotte1 = new Legume("carotte","carotte orange",EtatIngredient.SOLIDE);
        Legume carotte2 = new Legume("carotte","carotte orange",EtatIngredient.SOLIDE);
        Legume carotteBlanche = new Legume("carotte","carotte blanche",EtatIngredient.SOLIDE);
        Legume carotteNaine = new Legume("carotteNaine","carotte orange",EtatIngredient.SOLIDE);
        Laitier jusDeCarotte = new Laitier("carotte","carotteOrange",EtatIngredient.LIQUIDE);

        assertFalse(carotte1.compare(carotteBlanche));
        assertFalse(carotte1.compare(carotteNaine));
        assertFalse(carotte1.compare(jusDeCarotte));
        assertTrue(carotte2.compare(carotte1));
    }
}