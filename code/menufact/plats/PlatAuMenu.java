package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private ArrayList<IngredientInventaire> listeIngredients;


    public ArrayList<IngredientInventaire> getListeIngredients() {
        return listeIngredients;
    }

    public void setListeIngredients(ArrayList<IngredientInventaire> listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    public PlatAuMenu(int code, String description, double prix)
    {
        this.code = code;
        this.description = description;
        this.prix = prix;
    }
    public PlatAuMenu(int code, String description, double prix, ArrayList<IngredientInventaire> listeIngredients) {
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.listeIngredients = listeIngredients;
    }

    public PlatAuMenu() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
