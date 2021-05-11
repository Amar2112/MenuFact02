package menufact.plats;

import ingredients.IngredientInventaire;

import java.util.ArrayList;

public interface Plats {
    /***
     *
     * @return Retourne la liste d'ingrédients du plat
     */
    ArrayList<IngredientInventaire> getListeIngredients();

    /***
     * Prend la liste d'ingrédients reçue en paramètre et l'attribue à sa liste.
     * @param listeIngredients
     */
    void setListeIngredients(ArrayList<IngredientInventaire> listeIngredients);

    @Override
    String toString();

    /***
     * Retourne le code du plat sur le menu.
     * @return
     */
    int getCode();

    /***
     * Permet de revoir à quelle position le plat est sur le menu.
     * @param code
     */
    void setCode(int code);

    /***
     * Permet de recevoir la description du plat
     * @return
     */
    String getDescription();

    /***
     * Permet de changer la description du plat
     * @param description
     */
    void setDescription(String description);

    /***
     * Permet d'avoir accès au prix du plat.
     * @return
     */
    double getPrix();

    /***
     * Permet de changer le prix du plat.
     * @param prix
     */
    void setPrix(double prix);
}


