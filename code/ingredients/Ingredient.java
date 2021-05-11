package ingredients;

public abstract class Ingredient {

    String nom;
    String description;
    TypeIngredient typeIngredient;
    EtatIngredient etat;

    public abstract EtatIngredient getEtat();

    public abstract void setEtat(EtatIngredient etat);

    public abstract String getNom();

    public abstract void setNom(String nom);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract TypeIngredient getTypeIngredient();

    public abstract boolean compare(Ingredient ingredient);

    @Override
    public String toString() {
        return "Ingredients.ingredient{" +
                "nom=" + nom +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                "TypeIngrédients=" + typeIngredient+ "}";
    }

}
