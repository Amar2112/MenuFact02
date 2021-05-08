package ingredients;

public class Laitier extends Ingredient{
    public Laitier( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.LAITIER;
        this.etat = etat;
    }
}
