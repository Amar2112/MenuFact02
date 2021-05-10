package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatServi implements EtatPlat{
    public EtatPlat setNextState(PlatChoisi p) throws PlatExceptions
    {
        throw new PlatExceptions("Le plat est déja servi");
    }

    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Servi }";
    }
}
