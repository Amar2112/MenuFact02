package ingredients;

public class Viande extends Ingredient {


    public Viande( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.VIANDE;
        this.etat = etat;
    }

    /**
     * Retourne l'état de l'ingrédient
     * @return l'état de l'ingrédient
     */
    @Override
    public EtatIngredient getEtat() {
        return etat;
    }

    /**
     * Attibuer un état de l'ingrédient
     * @param e l'état de l'ingrédient
     */
    @Override
    public void setEtat(EtatIngredient e) {
        etat = e;
    }

    /**
     * Retourne le nom de l'ingrédient
     * @return le nom de l'ingrédient
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Attribue le nom de l'ingrédient
     * @param n le nom de l'ingrédient
     */
    @Override
    public void setNom(String n) {
        nom = n;
    }

    /**
     * Retourne la description de l'ingrédient
     * @return la description de l'ingrédient
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Attribue la description
     * @param d
     */
    @Override
    public void setDescription(String d) {
        description = d;
    }

    /**
     *
     * @return le type d'ingrédient
     */
    @Override
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Compare les deux ingrédients
     * @param ingredient
     * @return Retrourne vrai si les deux ingrédients ont les mêmes attributs
     */
    @Override
    public boolean compare(Ingredient ingredient) {
        if (!this.nom.equals(ingredient.nom))
            return false;
        else if (!this.description.equals(ingredient.getDescription()))
            return false;
        else if (!this.typeIngredient.equals(ingredient.typeIngredient))
            return false;
        else if (!this.etat.equals(ingredient.etat))
            return false;
        return true;
    }
}
