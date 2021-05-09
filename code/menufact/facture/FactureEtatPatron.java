package menufact.facture;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.Date;

public interface FactureEtatPatron {
    public void payer() throws FactureException;
    public void fermer() throws FactureException;
    public void ouvrir() throws FactureException;
    public FactureEtat getEtat();
    public String genererFacture(final double TPS,final double TVQ);
    //TODO: Il manque de regarder si le plat peut être choisi grâce à l'inventaire
    public void ajoutePlat(PlatChoisi p) throws FactureException;
}
