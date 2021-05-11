package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.EtatDesPlats;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class FactureOuverte implements  FactureEtatPatron{
    private Facture facture;

    public FactureOuverte(Facture facture)
    {
        this.facture = facture;
    }
    public void payer() throws FactureException
    {

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

    public ArrayList<PlatChoisi> ajoutePlat(PlatChoisi p) throws FactureException
    {

         ArrayList<PlatChoisi> temp = facture.getPlatchoisi();
         temp.add(p);
         for(PlatChoisi plat : facture.getPlatchoisi())
         {
             if(plat.getPlat().getCode() == p.getPlat().getCode()){
                 throw new FactureException("Le plat est déjà présent");
             }
         }
         return temp;
    }

    public ArrayList<PlatChoisi> retirerPlat(int code) throws FactureException
    {
       ArrayList<PlatChoisi> platChoisi = facture.getPlatchoisi();
        for (int i = 0; i< platChoisi.size();i++) {
            if(platChoisi.get(i).getPlat().getCode() == code)
            {
                platChoisi.remove((platChoisi.get(i).getPlat()));
                return platChoisi;
            }
        }
        throw new FactureException("Le plat ne figure pas dans la liste");
    }
    public ArrayList<PlatChoisi> changerPlat(int code, int quantite) throws FactureException
    {
        ArrayList<PlatChoisi> platChoisi = facture.getPlatchoisi();
        for (int i = 0; i< platChoisi.size();i++) {
            if(platChoisi.get(i).getPlat().getCode() == code)
            {
                PlatChoisi plat = new PlatChoisi(platChoisi.get(i).getPlat(),quantite);
                platChoisi.set(i,plat);
                return platChoisi;
            }
        }
        throw new FactureException("Le plat ne figure pas dans la liste");
    }
}
