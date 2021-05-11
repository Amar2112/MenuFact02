package ingredients;

public class Fruit extends Ingredient {

    public Fruit( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.FRUIT;
        this.etat = etat;
    }

    @Override
    public EtatIngredient getEtat() {
        return etat;
    }

    @Override
    public void setEtat(EtatIngredient e) {
        etat = e;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String n) {
        nom = n;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String d) {
        description = d;
    }

    @Override
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

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
