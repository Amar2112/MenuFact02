package menufact.plats;

import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import inventaire.Inventaire;
import menufact.plats.exceptions.PlatExceptions;

public class PlatCommande implements EtatPlat{
    private Inventaire inventaire;
    private PlatChoisi platChoisi;
    @Override
    public EtatPlat setNextState(PlatChoisi p){
        try{
            inventaire.isDisponible(p);
        }catch(InventaireException | IngredientException e){
            return new PlatImpossible();
        }
        return new PlatEnPreparation();

    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Commande }";
    }
}
