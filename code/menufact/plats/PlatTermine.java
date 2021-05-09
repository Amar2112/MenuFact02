package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatTermine implements EtatPlat{
    public EtatPlat setNextState() throws PlatExceptions
    {
        return new PlatServi();
    }
}
