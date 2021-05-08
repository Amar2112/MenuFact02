package ingredients;

public class Ingredient {
    protected String nom;
    protected String description;
    protected TypeIngredient typeIngredient;
    protected EtatIngredient etat;

    public EtatIngredient getEtat() {
        return etat;
    }

    public void setEtat(EtatIngredient etat) {
        this.etat = etat;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

   /* public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
    */

    public boolean compare(Ingredient ingredient)
    {
        if(this.nom != ingredient.nom)
            return false;
        if(this.description != ingredient.getDescription())
            return false;
        if(this.typeIngredient != ingredient.typeIngredient)
            return false;
        if(this.etat != ingredient.etat)
            return false;
        return true;

    }
}
