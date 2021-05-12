package menufact.plats;

import ingredients.IngredientInventaire;
import menufact.plats.exceptions.PlatExceptions;

import java.util.ArrayList;

public class PlatAuMenu implements Plats {
    private int code;
    private String description;
    private double prix;
    private ArrayList<IngredientInventaire> listeIngredients;
    /***
     *
     * @return Retourne la liste d'ingrédients du plat
     */
    public ArrayList<IngredientInventaire> getListeIngredients() {
        return listeIngredients;
    }
    /***
     * Prend la liste d'ingrédients reçue en paramètre et l'attribue à sa liste.
     * @param listeIngredients
     */
    public void setListeIngredients(ArrayList<IngredientInventaire> listeIngredients) {
        this.listeIngredients = listeIngredients;
    }

    /***
     * Constructeur de PlatAuMenu
     * @param code
     * @param description
     * @param prix
     */
    public PlatAuMenu(int code, String description, double prix){
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    /***
     * Constructeur de PlatAuMenu
     * @param code
     * @param description
     * @param prix
     */
    public PlatAuMenu(int code, String description, double prix, ArrayList<IngredientInventaire> listeIngredients){
        this.code = code;
        this.description = description;
        this.prix = prix;
        this.listeIngredients = listeIngredients;
    }

    /***
     * Constructeur de PlatAuMenu
     */
    public PlatAuMenu() {
        this.code = 0;
        this.description = "";
        this.prix = 0;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    /***
     * Retourne le code du plat sur le menu.
     * @return
     */
    public int getCode() {
        return code;
    }

    /***
     * Permet de revoir à quelle position le plat est sur le menu.
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /***
     * Permet de recevoir la description du plat
     * @return
     */
    public String getDescription() {
        return description;
    }

    /***
     * Permet de changer la description du plat
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * Permet d'avoir accès au prix du plat.
     * @return
     */
    public double getPrix() {
        return prix;
    }

    /***
     * Permet de changer le prix du plat.
     * @param prix
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
}