package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }
    public PlatEnfant(int code, String description, double prix, double proportion) {
        super(code, description, prix);
        this.proportion = proportion;
    }
    public PlatEnfant(int code, String description, double prix, double proportion, ArrayList<IngredientInventaire> listeIngredient) {
        super(code, description, prix, listeIngredient);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
