package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public interface EtatPlat {
    public EtatPlat setNextState() throws PlatExceptions;
}
