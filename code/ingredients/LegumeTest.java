package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegumeTest {

    /**
     * Tester getEtat
     */
    @Test
    void getEtat() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }
    /**
     * Tester setEtat
     */
    @Test
    void setEtat() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }
    /**
     * Tester getNom
     */
    @Test
    void getNom() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals("Cocombre", e.getNom());
    }
    /**
     * Tester setNom
     */
    @Test
    void setNom() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setNom("Poivron");
        assertEquals("Poivron", e.getNom());
    }
    /**
     * Tester getDescription
     */
    @Test
    void getDescription() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals("Crunchy", e.getDescription());
    }
    /**
     * Tester setDescription
     */
    @Test
    void setDescription() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        e.setDescription("Franchement crunchy");
        assertEquals("Franchement crunchy", e.getDescription());
    }
    /**
     * Tester getTypeIngredient
     */
    @Test
    void getTypeIngredient() {
        Legume e = new Legume("Cocombre","Crunchy",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.LEGUME, e.getTypeIngredient());
    }


    /**
     * Tester compare en comparant deux éléments qui ont une caractéristique différente
     */
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