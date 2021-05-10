package menufact.plats;

import menufact.plats.exceptions.PlatExceptions;

public class PlatImpossible implements EtatPlat{
    public EtatPlat setNextState(PlatChoisi p) throws PlatExceptions
    {
        throw new PlatExceptions("Il manque d'ingredients");
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Manque d'ingredients}";
    }
}
