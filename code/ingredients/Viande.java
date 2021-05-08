package ingredients;

public class Viande extends Ingredient{
    public Viande( String nom,String description,TypeIngredient typeIngredient, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.VIANDE;
        this.etat = etat;
    }
}
