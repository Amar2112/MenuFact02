package menufact.plats;

import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;

public interface EtatPlat {
    public EtatPlat setNextState(PlatChoisi p, Facture facture) throws PlatExceptions;
    public EtatDesPlats getEtatPlat();
    @Override
    public String toString();
}
