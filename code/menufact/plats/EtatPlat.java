package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public interface EtatPlat {
    public EtatPlat setNextState(PlatChoisi p) throws PlatExceptions;
    @Override
    public String toString();
}
