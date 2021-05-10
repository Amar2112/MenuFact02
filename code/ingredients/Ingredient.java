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
    public abstract void setTypeIngredient(TypeIngredient t);

    public boolean compare(Ingredient ingredient) {
        if (this.nom != ingredient.nom)
            return false;
        if (this.description != ingredient.getDescription())
            return false;
        if (this.typeIngredient != ingredient.typeIngredient)
            return false;
        if (this.etat != ingredient.etat)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Ingredients.ingredient{" +
                "nom=" + nom +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                "TypeIngrédients=" + typeIngredient+ "}";
    }

}
