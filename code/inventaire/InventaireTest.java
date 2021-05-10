package inventaire;

import ingredients.EtatIngredient;
import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IngredientInventaire;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @Test
    void getLesIngredients() {
        Inventaire inv = Inventaire.getInstance();

    }

    @Test
    void getInstance() {
        Inventaire inv = Inventaire.getInstance();
        assertEquals(inv,Inventaire.getInstance());
    }

    @Test
    void ajouter() {
        Ingredient fraise = new Fruit("Fraise","Miam", EtatIngredient.SOLIDE);
        IngredientInventaire ingInv = new IngredientInventaire(fraise,200);
        Inventaire inv = Inventaire.getInstance();
        inv.ajouter(ingInv);
        assertEquals(1,inv.getLesIngredients().size());
    }

    @Test
    void indexIngredient() {
        Ingredient fraise = new Fruit("Fraise","Miam", EtatIngredient.SOLIDE);
        IngredientInventaire ingInv = new IngredientInventaire(fraise,200);
        Inventaire inv = Inventaire.getInstance();
        inv.ajouter(ingInv);
        assertEquals(0,inv.indexIngredient(ingInv));
    }

    @Test
    void isDisponible() {
    }

    @Test
    void rectifierInventaire() {
    }

    @Test
    void testToString() {
    }
}