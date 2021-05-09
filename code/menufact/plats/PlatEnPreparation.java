package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatEnPreparation implements EtatPlat{
    public EtatPlat setNextState() throws PlatExceptions
    {
        return new PlatTermine();
    }
}
