package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FruitTest {

    @Test
    void getEtat() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals("Fraise", e.getNom());
    }

    @Test
    void setNom() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setNom("Poire");
        assertEquals("Poire", e.getNom());
    }

    @Test
    void getDescription() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals("Delicious", e.getDescription());
    }

    @Test
    void setDescription() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.FRUIT, e.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        e.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE,e.getTypeIngredient());
    }

    @Test
    void compare() {
    }
}