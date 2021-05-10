package inventaire;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
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

    public int indexIngredient(IngredientInventaire ingredient)
    {
        for (int i = 0; i < lesIngredients.size(); i++) {
            if (ingredient.getIngredient().compare(lesIngredients.get(i).getIngredient()) == true) {

                return i;
            }
        }
        return -1;
    }
    public boolean isDisponible(PlatChoisi p)
    {
        for (IngredientInventaire lesIngredientsDuPlat:p.getPlat().getListeIngredients()) {
            int index = indexIngredient(lesIngredientsDuPlat);
            if(index == -1 )
            {
                return false;
            }
            else{
                if(lesIngredientsDuPlat.getQuantite()*p.getQuantite() > lesIngredients.get(index).getQuantite()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean rectifierInventaire(PlatChoisi p)
    {
        if(isDisponible(p))
        {
            for(IngredientInventaire lesIngredientsDuPlat:p.getPlat().getListeIngredients()) {
                int index = indexIngredient(lesIngredientsDuPlat);
                try{
                    lesIngredients.get(index).setQuantite(lesIngredients.get(index).getQuantite() - lesIngredientsDuPlat.getQuantite() * p.getQuantite());
                }
                catch (IngredientException i){
                    return false;
                }

            }

        }
        else{
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "inventaire.Inventaire{" +
                "Liste d'ingredients" + lesIngredients+
                '}';
    }
}

