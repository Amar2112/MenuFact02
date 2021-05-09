package ingredients;

public class Legume implements Ingredient{
    String nom;
    String description;
    TypeIngredient typeIngredient;
    EtatIngredient etat;

    public Legume( String nom,String description, EtatIngredient etat){
        this.nom = nom;
        this.description = description;
        this.typeIngredient = TypeIngredient.LEGUME;
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
    public void setTypeIngredient(TypeIngredient t) {
        typeIngredient = t;
    }
}
