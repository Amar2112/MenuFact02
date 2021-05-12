package ingredients;
import ingredients.exceptions.IngredientException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientInventaireTest {
    /**
     * Teste getQuantite
     */
    @Test
    void getQuantite() {
        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        IngredientInventaire inventaire1 = new IngredientInventaire(e,3);

        assertEquals(3, inventaire1.getQuantite());
    }

    /**
     * Teste le bon fonctionnement de setQuantite avec une valeur positive
     */
    @Test
    public void setQuantitePositive(){

        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        IngredientInventaire inventaire1 = new IngredientInventaire(e,3);
        System.out.println(inventaire1);

        try{
            inventaire1.setQuantite(9);
        }
        catch(IngredientException i)
        {
            i.printStackTrace();
        }
        assertEquals(9, inventaire1.getQuantite());
    }

    /**
     * Teste le cas limite où la quantité est négative
     */
    @Test
    public void setQuantiteNegative(){

        Fruit e = new Fruit("Fraise","Delicious",EtatIngredient.SOLIDE);
        IngredientInventaire inventaire1 = new IngredientInventaire(e,3);

        try{
            inventaire1.setQuantite(-9);
        }
        catch(IngredientException i)
        {
            assertTrue(i.getMessage().contains("Il n'est pas possible d'avoir une quantité negative"));
        }

    }
}
