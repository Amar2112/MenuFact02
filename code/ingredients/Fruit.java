package ingredients;

public class Fruit extends Ingredient{
    public Fruit( String nom,String description,TypeIngredient typeIngredient, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.FRUIT;
        this.etat = etat;
    }
}
