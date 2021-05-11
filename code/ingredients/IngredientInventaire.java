package ingredients;
import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient ingredient;
    private int quantite;

    /**
     * Constucteur d'ingrédients
     * @param ingredient
     * @param quantite
     */
    public IngredientInventaire(Ingredient ingredient, int quantite) {
        this.ingredient = ingredient;
        try{
            this.setQuantite(quantite);
        }catch(IngredientException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Retourne la quantite de l'ingrédient inventaire
     * @return quantite de l'ingrédient inventaire
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Attribue une quantité à l'ingrédient inventaire
     * @param quantite
     * @throws IngredientException si la quantité est inférieure à 1
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }

    /**
     * Attribue un ingrédient à l'inventaire d el'ingrédient
     * @return
     */
    public Ingredient getIngredient(){ return ingredient; }

    /**
     * Retourne les valeurs de l'ingrédient inventaire en forme de string
     * @return les valeurs de l'ingrédient inventaire
     */
    @Override
    public String toString() {
        String string = "Ingredients.IngredientInventaire{ " +
                "Ingredient " + ingredient+
                "Quantite= " + quantite;
                if(ingredient.getEtat() == EtatIngredient.LIQUIDE){
                   string+=  "ml"; }
                else{
                    string += "g ";
                }
                string +='}';
                return string;
    }
}
