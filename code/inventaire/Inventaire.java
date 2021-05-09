package inventaire;

import ingredients.IngredientInventaire;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Inventaire {
    private static Inventaire instance;
    private ArrayList<IngredientInventaire> lesIngredients;


    //Getter
    public ArrayList<IngredientInventaire> getLesIngredients() {
        return lesIngredients;
    }


    private Inventaire(){
        lesIngredients = new ArrayList<IngredientInventaire>();
    }

    public static Inventaire getInstance()
    {
        if(instance == null)
        {
            instance = new Inventaire();
        }
        return instance;
    }

    public void ajouter (IngredientInventaire ingredient)
    {
        lesIngredients.add(ingredient);
    }

    public Boolean isDisponible(PlatChoisi p)
    {
        boolean ingredientPresent = false;
        for(int j = 0; j <p.getPlat().getListeIngredients().size(); j++){
            ingredientPresent = false;
            for( int i = 0; i < lesIngredients.size(); i++)
            {
//                if(p.getPlat().getListeIngredients().get(j).getIngredient().compare(lesIngredients.get(i).getIngredient()) == true) {
//                    ingredientPresent = true;
//                    if(lesIngredients.get(i).getQuantite() < p.getQuantite()*(p.getPlat().getListeIngredients().get(j).getQuantite()))
//                    {
//                        return false;
//                    }
//                }
            }
            if(!ingredientPresent)
            {
                return false;
            }
        }

        return true;
    }
}
