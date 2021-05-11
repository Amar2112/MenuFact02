package menufact.plats;

import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;
/***
 * Classe qui représente l'état dans lequel un plat peut être selon son avancement dans la chaîne.
 */
public class PlatImpossible implements EtatPlat{
    public EtatPlat setNextState(PlatChoisi p, Facture facture) throws PlatExceptions
    {
        throw new PlatExceptions("Il manque d'ingredients");
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Manque d'ingredients}";
    }

    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.IMPOSSIBLE;
    }
}
