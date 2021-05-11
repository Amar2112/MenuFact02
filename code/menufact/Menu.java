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

    public static Menu getInstance() {
        if(instance == null)
        {
            instance = new Menu();
        }
        return instance;
    }

    public void ajoute(PlatAuMenu p) throws MenuException{
        for (PlatAuMenu plats:plat) {
            if(plats.getCode() == p.getCode())
            {
                throw new MenuException("Le code est déjà présent");
            }
        }
        plat.add(p);
    }

    public void position(int i) {
        courant = i;
    }

    public PlatAuMenu platCourant() {
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException {
        if (courant + 1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException {
        if (courant - 1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    public void afficherPlats()
    {
        System.out.println(plat);
    }

    public void afficherPlat(int code)throws MenuException
    {
        PlatAuMenu p = getPlatAvecCode(code);
        System.out.println(p);
    }

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

    public Plats createPlat(){
        return new PlatAuMenu();
    }

    public int getCourant(){
        return courant;
    }
}
