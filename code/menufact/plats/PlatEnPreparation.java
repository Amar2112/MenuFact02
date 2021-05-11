package menufact.plats;

import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;

public class PlatEnPreparation implements EtatPlat{
    Inventaire inventaire;
    public EtatPlat setNextState(PlatChoisi p, Facture facture)
    {
        try{
            inventaire = Inventaire.getInstance();
            inventaire.rectifierInventaire(p);
        }
        catch (InventaireException e){
            return new PlatImpossible();
        }
        catch (IngredientException e){

        }
        return new PlatTermine();
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  En preparation }";
    }

    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.ENPREPARATION;
    }
}
