package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatEnPreparation implements EtatPlat{
    public EtatPlat setNextState() throws PlatExceptions
    {
        return new PlatTermine();
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  En preparation }";
    }
}
