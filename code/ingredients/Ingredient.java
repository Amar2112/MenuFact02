package ingredients;

public interface Ingredient {

    public EtatIngredient getEtat();

    public void setEtat(EtatIngredient etat);

    public String getNom();

    public void setNom(String nom);

    public String getDescription();

    public void setDescription(String description);

    public TypeIngredient getTypeIngredient();
    public void setTypeIngredient(TypeIngredient t);
   /* public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
    */
    public boolean compare(Ingredient ingredient)
    {
        if(this.nom != ingredient.nom)
            return false;
        if(this.description != ingredient.getDescription())
        if(this.typeIngredient != ingredient.typeIngredient)
            return false;
            return false;
        if(this.etat != ingredient.etat)
            return false;
        return true;

}
