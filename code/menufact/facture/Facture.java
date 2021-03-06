package menufact.facture;

import menufact.*;
import menufact.EventManager;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.EtatDesPlats;
import menufact.plats.EtatPlat;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private Menu menu;


    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private EventManager eventManager;
    private int courant;
    private Client client;
    private FactureEtatPatron etatFacture;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de changer l'état de la facture à PAYEE
     */
    public void payer()
    {
       try
       {
            etatFacture.payer();
            etatFacture = new FacturePayee(this);
            etat = etatFacture.getEtat();

       }catch (FactureException exception)
       {
           exception.printStackTrace();
       }
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
        try
        {
            etatFacture.fermer();
            etatFacture = new FactureFermee(this);
            etat = etatFacture.getEtat();

        }catch (FactureException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
            etatFacture.ouvrir();
            etatFacture = new FactureOuverte(this);
            etat = etatFacture.getEtat();
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = FactureEtat.OUVERTE;
        etatFacture = new FactureOuverte(this);
        eventManager = new EventManager();
        menu = Menu.getInstance();
        courant = -1;
        this.description = description;
    }
    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException,MenuException{
            if(menu == null){
                throw new FactureException("Le menu n'est pas instancié");
            }
            PlatAuMenu temp = menu.getPlatAvecCode(p.getPlat().getCode());
            p.nextEtat(this);
            if(p.getEtatPlat() == EtatDesPlats.IMPOSSIBLE )
           {
                throw new FactureException("Impossible d'ajouter le plat, car il n'y a pas assez d'ingredients");
            }

            platchoisi =  etatFacture.ajoutePlat(p);
    }

    public void ajoutePlat(int code, int quantite) throws MenuException,FactureException
    {
        PlatAuMenu temp = menu.getPlatAvecCode(code);
        PlatChoisi nouveauPlat = new PlatChoisi(temp, quantite);
        this.ajoutePlat(nouveauPlat);
    }
    public void changerQuantitePlat(int code, int quantite)throws MenuException,FactureException
    {
        PlatAuMenu temp = menu.getPlatAvecCode(code);
        platchoisi = etatFacture.changerPlat(code,quantite);
    }

    public void enleverPlat(int code)throws MenuException,FactureException
    {
        PlatAuMenu temp = menu.getPlatAvecCode(code);
        platchoisi = etatFacture.retirerPlat(code);
    }
    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        courant = menu.getCourant();
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()throws FactureException
    {
        if(client == null){
            throw new FactureException("Il n'y a pas de client assigné à la facture");
        }
        int j = platchoisi.size() - 1;
        for(int i = j; i >=0; i--)
        {
            if(platchoisi.get(i).getEtatPlat() == EtatDesPlats.IMPOSSIBLE || platchoisi.get(i).getEtatPlat() == EtatDesPlats.PASCOMMANDE)
            {
                platchoisi.remove(platchoisi.get(i));
            }
        }
        return etatFacture.genererFacture(tps(),tvq());
    }
    public ArrayList<PlatChoisi> getPlatchoisi() {
        return platchoisi;
    }
    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getCourant() {
        return courant;
    }

    public Client getClient() {
        return client;
    }

    public EventManager getEM()
    {
        return eventManager;
    }

    /**
     * Set les EventManager de la facture
     * @param em
     */
    public void engagerDesChefs(EventManager em){
        this.eventManager = em;
    }
}
