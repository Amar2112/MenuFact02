package menufact.plats;

import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;

public class PlatCommande implements EtatPlat{
    private Inventaire inventaire;
    private PlatChoisi platChoisi;
    @Override
    public EtatPlat setNextState(PlatChoisi p, Facture facture){
        try{
            inventaire.isDisponible(p);
        }catch(InventaireException i){
            return new PlatImpossible();
        }
        return new PlatEnPreparation();

    }

    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.COMMANDE;
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Commande }";
    }
}
