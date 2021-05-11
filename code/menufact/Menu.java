package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.Plats;

import java.util.ArrayList;

public class Menu {
    private final String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    private static Menu instance;

    private Menu(){ this.description = "menuFact.Menu";}

    /***
     * Fonction propre au modèle de conception Singleton qui permet d'avoir seulement 1 élément de type Menu
     * @return retourne le menu
     */
    public static Menu getInstance() {
        if(instance == null)
        {
            instance = new Menu();
        }
        return instance;
    }

    /***
     * Ajoute un objet de type PlatAuMenu dans la liste de PlatAuMenu s'il n'existe pas déjà dans cette liste.
     * @param p
     * @throws MenuException
     */
    public void ajoute(PlatAuMenu p) throws MenuException{
        for (PlatAuMenu plats:plat) {
            if(plats.getCode() == p.getCode())
            {
                throw new MenuException("Le code est déjà présent");
            }
        }
        plat.add(p);
    }

    /***
     * Permet de choisir un item à la position voulue dans le Menu.
     * @param i
     */
    public void position(int i) {
        courant = i;
    }

    /***
     *
     * @return Retourne le PlatAuMenu contenu dans la liste de plats à l'index courante.
     */
    public PlatAuMenu platCourant() {
        return plat.get(courant);
    }

    /***
     * Permet de naviguer plus loin dans le menu et ainsi voir les autres plats.
     * @throws MenuException
     */
    public void positionSuivante() throws MenuException {
        if (courant + 1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /***
     * Permet de revenir sur ses pas dans le menu et ainsi revoir les plats déjà vu.
     * @throws MenuException
     */
    public void positionPrecedente() throws MenuException {
        if (courant - 1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /***
     * Permet d'afficher la liste de tous les plats sur le menu.
     */
    public void afficherPlats()
    {
        System.out.println(plat);
    }

    /***
     * Permet d'afficher un plat spécifique en fonction de son code.
     * @param code : index d'accès à la liste de plats.
     * @throws MenuException
     */
    public void afficherPlat(int code)throws MenuException
    {
        PlatAuMenu p = getPlatAvecCode(code);
        System.out.println(p);
    }

    /***
     * Permet d'avoir accès à un plat spécifique en fonction de son code.
     * @param code : index d'accès à la liste de plats.
     * @return Le platAuMenu relié au code reçu en paramètre
     * @throws MenuException
     */
    public PlatAuMenu getPlatAvecCode(int code) throws MenuException
    {
        for (PlatAuMenu platMenu: plat) {
            if(platMenu.getCode() == code){
                return platMenu;
            }
        }
        throw new MenuException("Le code n'est pas dans le menu");
    }
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }

    /***
     * Permet de créer un nouveau Plat
     * @return
     */
    public Plats createPlat(){
        return new PlatAuMenu();
    }

    /***
     * Retourne l'index à laquelle nous sommes rendu dans le menu.
     * @return l'index courante du menu.
     */
    public int getCourant(){
        return courant;
    }
}
