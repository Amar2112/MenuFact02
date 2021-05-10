package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;

public interface Plats {

    ArrayList<IngredientInventaire> getListeIngredients();

    void setListeIngredients(ArrayList<IngredientInventaire> listeIngredients);

    @Override
    String toString();

    int getCode();

    void setCode(int code);

    String getDescription();

    void setDescription(String description);

    double getPrix();

    void setPrix(double prix);
}


