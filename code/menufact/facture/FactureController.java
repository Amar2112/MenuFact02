package menufact.facture;

import menufact.Client;
import menufact.EventManager;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

public class FactureController {
    private Facture facture;
    private FactureView factureView;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        facture.associerClient(client);
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()
    {
      facture.payer();
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
        facture.fermer();
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        facture.ouvrir();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return facture.getEtat();
    }

    /**
     *
     * @param description la description de la Facture
     */
    public FactureController(String description) {
        facture = new Facture(description);
        factureView = new FactureView();
    }
    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, MenuException{

        facture.ajoutePlat(p);

    }

    public void ajoutePlat(int code, int quantite) throws MenuException,FactureException
    {
        facture.ajoutePlat(code,quantite);
    }
    public void changerQuantitePlat(int code, int quantite)throws MenuException,FactureException
    {
        facture.changerQuantitePlat(code,quantite);
    }

    public void enleverPlat(int code)throws MenuException,FactureException
    {
       facture.enleverPlat(code);
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public void genererFacture() throws FactureException
    {
        factureView.genererFacture(facture.genererFacture());
    }
    public ArrayList<PlatChoisi> getPlatchoisi() {
        return facture.getPlatchoisi();
    }
    public Date getDate() {
        return facture.getDate();
    }

    public String getDescription() {
        return facture.getDescription();
    }

    public int getCourant() {
        return facture.getCourant();
    }

    public Client getClient() {
        return facture.getClient();
    }

    public EventManager getEM()
    {
        return facture.getEM();
    }
}
