package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class FacturePayee implements  FactureEtatPatron{
    private Facture facture;

    public FacturePayee(Facture facture)
    {
        this.facture = facture;
    }
    /***
     * On est déjà dans l'état payer donc on change rien
     * @throws FactureException
     */
    public void payer() throws FactureException
    {
        throw new FactureException("La facture est à l'état payée");
    }

    /***
     * On ne peut plus changer d'état car la facture est règlée
     * @throws FactureException
     */
    public void fermer() throws FactureException
    {
        throw new FactureException("La facture est à l'état payée, impossible de la fermer");
    }

    /**
     * On ne peut plus changer d'état car la facture est règlée
     * @throws FactureException
     */
    public void ouvrir() throws FactureException
    {
        throw new FactureException("La facture est à l'etat payee, il est impossible de l'ouvrir");
    }

    /***
     *
     * @return Retourne l'état de la facture actuelle
     */
    public FactureEtat getEtat()
    {
        return FactureEtat.PAYEE;
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
        factureGenere += "Payé avec carte : " + facture.getClient().getNumeroCarteCredit();
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
     * @return Retourne une exception car on ne peux pas ajouter un plat dans l'état payée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> ajoutePlat(PlatChoisi p) throws FactureException
    {
       throw new FactureException("La facture doit être ouverte pour ajouter un plat");
    }
    /***
     *
     * @param code
     * @return Retourne une exception car on ne peux pas retirer un plat dans l'état payée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> retirerPlat(int code) throws FactureException
    {
        throw new FactureException("On ne peut pas retirer un plat quand la facture est payée");
    }
    /***
     *
     * @param code
     * @param quantite
     * @return Retourne une exception car on ne peux pas changer un plat dans l'état payée
     * @throws FactureException
     */
    public ArrayList<PlatChoisi> changerPlat(int code, int quantite) throws FactureException
    {
        throw new FactureException("On ne peut pas changer un plat quand la facture est payée");
    }
}
