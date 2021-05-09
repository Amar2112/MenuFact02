package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatImpossible implements EtatPlat{
    public EtatPlat setNextState() throws PlatExceptions
    {
        throw new PlatExceptions("Il manque d'ingredients");
    }
}
