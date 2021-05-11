package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class FactureFermee implements  FactureEtatPatron{
    private Facture facture;

    public FactureFermee(Facture facture)
    {
        this.facture = facture;
    }

    /***
     * Permet de passer à l'état payer
     * @throws FactureException
     */
    public void payer() throws FactureException
    {
    }

    /***
     * On est déjà à l'état fermée
     * @throws FactureException
     */
    public void fermer() throws FactureException
    {
        throw new FactureException("La facture est à l'état fermee");
    }

    /**
     * Permet de passer à l'état ouvrir
     * @throws FactureException
     */
    public void ouvrir() throws FactureException
    {
    }

    /***
     *
     * @return l'état de la facture dans cette classe qui est fermée
     */
    public FactureEtat getEtat()
    {
        return FactureEtat.FERMEE;
    }

    /***
     *
     * @param TPS
     * @param TVQ
     * @return Une string qui contient la facture complète du client
     */
    public String genererFacture(final double TPS,final double TVQ)
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + facture.getDate() + "\n" +
                "Description: " + facture.getDescription() + "\n" +
                "Client:" + facture.getClient().getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : facture.getPlatchoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "         Le sous total est de: " + facture.sousTotal() + "\n";
        factureGenere += "         TPS:                  " + TPS + "\n";
        factureGenere += "         TVQ:                  " + TVQ + "\n";
        factureGenere += "         Le total est de:      " + facture.total() + "\n";

        return factureGenere;
    }

    /***
     * Ajoute la facture à notre état
     * @param facture
     */
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    /***
     *
     * @param p
     * @return Retourne une exception car on ne peux pas ajouter un plat dans l'état fermée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> ajoutePlat(PlatChoisi p) throws FactureException
    {
        throw new FactureException("La facture doit être ouverte pour ajouter un plat");
    }

    /***
     *
     * @param code
     * @return Retourne une exception car on ne peux pas retirer un plat dans l'état fermée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> retirerPlat(int code) throws FactureException
    {
        throw new FactureException("On ne peut pas retirer un plat quand la facture est fermée");
    }

    /***
     *
     * @param code
     * @param quantite
     * @return Retourne une exception car on ne peux pas changer un plat dans l'état fermée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> changerPlat(int code, int quantite) throws FactureException
    {
        throw new FactureException("On ne peut pas changer un plat quand la facture est fermée");
    }
}