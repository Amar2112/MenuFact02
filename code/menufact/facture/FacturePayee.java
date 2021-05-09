package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class FacturePayee implements  FactureEtatPatron{
    private Facture facture;

    public FacturePayee(Facture facture)
    {
        this.facture = facture;
    }
    public void payer() throws FactureException
    {
        throw new FactureException("La facture est à l'état payée");
    }
    public void fermer() throws FactureException
    {
        throw new FactureException("La facture est à l'état payée");
    }
    public void ouvrir() throws FactureException
    {
        throw new FactureException("La facture est à l'état payée ");
    }

    public FactureEtat getEtat()
    {
        return FactureEtat.PAYEE;
    }
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
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
       throw new FactureException("La facture doit être ouverte pour ajouter un plat");
    }

}