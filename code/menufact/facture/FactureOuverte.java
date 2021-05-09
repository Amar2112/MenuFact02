package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

public class FactureOuverte implements  FactureEtatPatron{
    private Facture facture;

    public FactureOuverte(Facture facture)
    {
        this.facture = facture;
    }
    public void payer() throws FactureException
    {
        throw new FactureException("La facture est à l'état ouvert, il faut fermer la facture pour payer");
    }
    public void fermer() throws FactureException
    {

    }
    public void ouvrir() throws FactureException
    {
        throw new FactureException("La facture est à l'état ouvert, il faut fermer la facture");
    }
    public FactureEtat getEtat()
    {
        return FactureEtat.OUVERTE;
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

        return factureGenere;
    }

    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        facture.getPlatchoisi();
    }

}
