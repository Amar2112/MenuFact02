package ingredients;

public class Legume extends Ingredient{
    public Legume( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.LEGUME;
        this.etat = etat;
    }
}
