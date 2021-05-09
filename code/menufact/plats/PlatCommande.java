package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatCommande implements EtatPlat{
    @Override
    public EtatPlat setNextState() throws PlatExceptions {
        return new PlatEnPreparation();
    }

}
