package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViandeTest {

    /**
     * Tester getEtat
     */
    @Test
    void getEtat() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    /**
     * Tester setEtat
     */
    @Test
    void setEtat() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());
    }

    /**
     * Tester getNom
     */
    @Test
    void getNom() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals("Steak", e.getNom());
    }

    /**
     * Tester setNom
     */
    @Test
    void setNom() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setNom("Épaule de porc");
        assertEquals("Épaule de porc", e.getNom());
    }

    /**
     * Tester getDescription
     */
    @Test
    void getDescription() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals("Mooouch", e.getDescription());
    }

    /**
     * Tester setDescription
     */
    @Test
    void setDescription() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    /**
     * Tester getTypeIngredient
     */
    @Test
    void getTypeIngredient() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.VIANDE, e.getTypeIngredient());
    }
    /**
     * Tester compare en comparant deux éléments qui ont une caractéristique différente
     */
    @Test
    void compare() {
        Viande viandeRouge1 = new Viande("viande","viande rouge",EtatIngredient.SOLIDE);
        Viande viandeRouge2 = new Viande("viande","viande rouge",EtatIngredient.SOLIDE);
        Viande viandeBlanche = new Viande("viande","viande blanche",EtatIngredient.SOLIDE);
        Viande viandeRougeBoeuf = new Viande("viande boeuf","viande rouge",EtatIngredient.SOLIDE);
        Viande viandeRougeLiquide = new Viande("viande","viande rouge",EtatIngredient.LIQUIDE);

        assertFalse(viandeRouge1.compare(viandeBlanche));
        assertFalse(viandeRouge1.compare(viandeRougeBoeuf));
        assertFalse(viandeRouge1.compare(viandeRougeLiquide));
        assertTrue(viandeRouge2.compare(viandeRouge1));
    }
}