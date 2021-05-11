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

    /**
     * Constructeur privé de la classe Inventaire
     */
    private Inventaire(){
        lesIngredients = new ArrayList<IngredientInventaire>();
    }

    /**
     * Fonction propre au modèle de conception Singleton qui permet d'avoir seulement 1 élément de type Inventaire
     * @return
     */
    public static Inventaire getInstance()
    {
        if(instance == null)
        {
            instance = new Inventaire();
            lesIngredients = new ArrayList<>();
        }
        return instance;
    }

    /**
     * Ajout d'un ingrédient dans la liste d'ingrédient.
     * @param ingredient
     */
    public void ajouter (IngredientInventaire ingredient)
    {
        lesIngredients.add(ingredient);
    }

    /**
     *
     * @param ingredient
     * @return Retourne l'index de l'ingrédient passé en paramètre si celui-ci est présent dans la liste d'ingrédient de l'inventaire.
     * @throws InventaireException
     */
    public int indexIngredient(IngredientInventaire ingredient) throws InventaireException
    {
        for (int i = 0; i < lesIngredients.size(); i++) {
            if (ingredient.getIngredient().compare(lesIngredients.get(i).getIngredient()) == true) {
                return i;
            }
        }
        throw new InventaireException("L'ingredient " + ingredient + " ne se trouve pas dans l'inventaire");
    }

    /**
     *
     * @param p
     * @return Retourne vrai si tout les ingrédients necéssaire à la fabrication du platChoisi est disponible.
     * @throws InventaireException
     */
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

    /**
     *
     * @param p
     * @return On vérifie si tout les ingrédients sont dispos puis on retourne true à la fin après avoir soustrait les ingrédients necéssaire à la fabrication.
     * @throws InventaireException
     * @throws IngredientException
     */
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

