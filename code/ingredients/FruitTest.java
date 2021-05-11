package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {
    /**
     * Tester getEtat
     */
    @Test
    void getEtat() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    /**
     * Tester setEtat
     */
    @Test
    void setEtat() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    /**
     * Tester getNom
     */
    @Test
    void getNom() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals("Fraise", e.getNom());
    }

    /**
     * Tester setNom
     */
    @Test
    void setNom() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setNom("Poire");
        assertEquals("Poire", e.getNom());
    }

    /**
     * Tester getDescription
     */
    @Test
    void getDescription() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals("Delicious", e.getDescription());
    }

    /**
     * Tester setDescription
     */
    @Test
    void setDescription() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    /**
     * Tester getTypeIngredient
     */
    @Test
    void getTypeIngredient() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.FRUIT, e.getTypeIngredient());
    }

    /**
     * Tester compare en comparant deux éléments qui ont une caractéristique différente
     */
    @Test
    void compare() {
        Fruit fraise1 = new Fruit("Fraise","Fruit rouge",EtatIngredient.SOLIDE);
        Fruit fraise2 = new Fruit("Fraise","Fruit rouge",EtatIngredient.SOLIDE);
        Fruit framboise = new Fruit("Framboise","Fruit rouge",EtatIngredient.SOLIDE);
        Fruit fraiseJaune = new Fruit("Fraise","Fruit jaune",EtatIngredient.SOLIDE);
        Fruit jusDeFraise = new Fruit("Fraise","Fruit rouge",EtatIngredient.LIQUIDE);

        assertFalse(fraise1.compare(framboise));
        assertFalse(fraise1.compare(fraiseJaune));
        assertFalse(fraise1.compare(jusDeFraise));
        assertTrue(fraise2.compare(fraise1));
    }
}