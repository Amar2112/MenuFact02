package ingredients;
import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        try{
            this.setQuantite(quantite);
        }catch(IngredientException e)
        {
            e.printStackTrace();
        }
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    public Ingredient getIngredient(){ return ingredient; }

    @Override
    public String toString() {
        return "Ingrdients.IngredientInventaire{" +
                "Ingredient" + ingredient+
                "Quantite" + quantite+
                '}';
    }
}
