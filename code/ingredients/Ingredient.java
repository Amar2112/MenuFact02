package ingredients;

public abstract class Ingredient {

    String nom;
    String description;
    TypeIngredient typeIngredient;
    EtatIngredient etat;

    /**
     * Retourne l'état de l'ingrédient
     * @return l'état de l'ingrédient
     */
    public abstract EtatIngredient getEtat();

    /**
     * Attibuer un état de l'ingrédient
     * @param e l'état de l'ingrédient
     */
    public abstract void setEtat(EtatIngredient e);

    /**
     * Retourne le nom de l'ingrédient
     * @return le nom de l'ingrédient
     */
    public abstract String getNom();

    /**
     * Attribue le nom de l'ingrédient
     * @param n le nom de l'ingrédient
     */
    public abstract void setNom(String n);

    /**
     * Retourne la description de l'ingrédient
     * @return la description de l'ingrédient
     */
    public abstract String getDescription();

    /**
     * Attribue la description
     * @param d
     */
    public abstract void setDescription(String d);
    /**
     *
     * @return le type d'ingrédient
     */
    public abstract TypeIngredient getTypeIngredient();

    /**
     * Compare les deux ingrédients
     * @param ingredient
     * @return Retrourne vrai si les deux ingrédients ont les mêmes attributs
     */
    public abstract boolean compare(Ingredient ingredient);

    /**
     * Affiche les données de l'ingrédient
     * @return un string
     */
    @Override
    public String toString() {
        return "Ingredients.ingredient{ " +
                "nom= " + nom +
                ", description=' " + description + '\'' +
                ", etat= " + etat +
                ", TypeIngrédients= " + typeIngredient+ " } ";
    }
}
