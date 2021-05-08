package ingredients;

public class Epice extends Ingredient {
    public Epice( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.EPICE;
        this.etat = etat;
        }
}
