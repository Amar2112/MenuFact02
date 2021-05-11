package menufact.plats;

import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;
/***
 * Interface servant de template aux classes qui représenteront l'état dans lequel un plat peut être selon son avancement dans la chaîne.
 */
public interface EtatPlat {
    public EtatPlat setNextState(PlatChoisi p, Facture facture) throws PlatExceptions;
    public EtatDesPlats getEtatPlat();
    @Override
    public String toString();
}
