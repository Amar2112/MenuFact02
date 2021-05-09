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


}
