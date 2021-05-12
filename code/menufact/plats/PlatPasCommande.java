package menufact.plats;

import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import inventaire.Inventaire;
import menufact.ChefException;
import menufact.facture.Facture;

public class PlatPasCommande implements EtatPlat{
    private Inventaire inventaire = Inventaire.getInstance();
    private PlatChoisi platChoisi;
    @Override
    public EtatPlat setNextState(PlatChoisi p, Facture facture){
        try{
            inventaire.isDisponible(p);
        }catch(InventaireException i){

            return new PlatImpossible();
        }
        try {
            facture.getEM().notifierChefs(p, facture);
        } catch (ChefException e) {
            return new PlatPasCommande();
        }
        return new PlatCommande();

    }

    public EtatDesPlats getEtatPlat()
    {
        return EtatDesPlats.PASCOMMANDE;
    }
    @Override
    public String toString() {
        return "plats.PlatEnPreparation{ Etat du plat =  Pas Commande }";
    }
}

