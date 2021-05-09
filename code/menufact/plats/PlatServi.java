package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatServi implements EtatPlat{
    public EtatPlat setNextState() throws PlatExceptions
    {
        throw new PlatExceptions("Le plat est déja servi");
    }
}
