package menufact.plats;

import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;

public class PlatServi implements EtatPlat{
    public EtatPlat setNextState(PlatChoisi p, Facture facture) throws PlatExceptions
    {
        throw new PlatExceptions("Le plat est déja servi");
    }

    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.SERVI;
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Servi }";
    }
}
