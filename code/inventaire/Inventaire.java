package inventaire;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class Inventaire {
    private static Inventaire instance;
    private  static ArrayList<IngredientInventaire> lesIngredients;


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
            lesIngredients = new ArrayList<>();
        }
        return instance;
    }

    public void ajouter (IngredientInventaire ingredient)
    {
        lesIngredients.add(ingredient);
    }

    public int indexIngredient(IngredientInventaire ingredient) throws InventaireException
    {
        for (int i = 0; i < lesIngredients.size(); i++) {
            if (ingredient.getIngredient().compare(lesIngredients.get(i).getIngredient()) == true) {
                return i;
            }
        }
        throw new InventaireException("L'ingredient " + ingredient + " ne se trouve pas dans l'inventaire");
    }
    public boolean isDisponible(PlatChoisi p) throws InventaireException {
        if(p.getPlat().getListeIngredients() == null){
            throw new InventaireException("Le plat n'a pas d'ingrédients");
        }
        for (IngredientInventaire lesIngredientsDuPlat:p.getPlat().getListeIngredients()) {
            int index = indexIngredient(lesIngredientsDuPlat);
            if(lesIngredientsDuPlat.getQuantite()*p.getQuantite() > lesIngredients.get(index).getQuantite()){
                throw new InventaireException("L'inventaire n'a pas assez de " + lesIngredientsDuPlat);
            }
        }
        return true;
    }

    public boolean rectifierInventaire(PlatChoisi p) throws InventaireException, IngredientException {
        isDisponible(p);
        for (IngredientInventaire lesIngredientsDuPlat : p.getPlat().getListeIngredients()) {
            int index = indexIngredient(lesIngredientsDuPlat);
            lesIngredients.get(index).setQuantite(lesIngredients.get(index).getQuantite() - (lesIngredientsDuPlat.getQuantite() * p.getQuantite()));
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

