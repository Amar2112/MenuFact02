package menufact.plats;

import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;
/***
 * Classe qui représente l'état dans lequel un plat peut être selon son avancement dans la chaîne.
 */
public class PlatTermine implements EtatPlat{
    public EtatPlat setNextState(PlatChoisi p, Facture facture)throws PlatExceptions
    {
        return new PlatServi();
    }
    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.TERMINE;
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Termine }";
    }
}
