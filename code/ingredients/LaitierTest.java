package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaitierTest {
    /**
     * Tester getEtat
     */
    @Test
    void getEtat() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());
    }
    /**
     * Tester setEtat
     */

    @Test
    void setEtat() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setEtat(EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());

    }
    /**
     * Tester getNom
     */
    @Test
    void getNom() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals("Lait", e.getNom());
    }
    /**
     * Tester setNom
     */
    @Test
    void setNom() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setNom("Crème");
        assertEquals("Crème", e.getNom());
    }
    /**
     * Tester getDescription
     */
    @Test
    void getDescription() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals("Moo", e.getDescription());
    }
    /**
     * Tester setDescription
     */
    @Test
    void setDescription() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }
    /**
     * Tester getTypeIngredient
     */
    @Test
    void getTypeIngredient() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals(TypeIngredient.LAITIER, e.getTypeIngredient());
    }
    /**
     * Tester compare en comparant deux éléments qui ont une caractéristique différente
     */
    @Test
    void compare() {
        Laitier lait1 = new Laitier("Lait","Lait blanc",EtatIngredient.LIQUIDE);
        Laitier lait2 = new Laitier("Lait","Lait blanc",EtatIngredient.LIQUIDE);
        Laitier laitDeSoya = new Laitier("Lait de Soya","Lait blanc",EtatIngredient.LIQUIDE);
        Laitier laitAuChocolat = new Laitier("Lait","Lait noir",EtatIngredient.LIQUIDE);
        Laitier yogourt = new Laitier("Lait","Lait blanc",EtatIngredient.SOLIDE);

        assertFalse(lait1.compare(laitDeSoya));
        assertFalse(lait1.compare(laitAuChocolat));
        assertFalse(lait1.compare(yogourt));
        assertTrue(lait2.compare(lait1));
    }
}




