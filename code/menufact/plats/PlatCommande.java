package menufact.plats;

import ingredients.exceptions.IngredientException;
import inventaire.Exceptions.InventaireException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.exceptions.PlatExceptions;
/***
 * Classe qui représente l'état dans lequel un plat peut être selon son avancement dans la chaîne.
 */
public class PlatCommande implements EtatPlat{
    private Inventaire inventaire;
    private PlatChoisi platChoisi;
    @Override
    public EtatPlat setNextState(PlatChoisi p, Facture facture){
        try{
            inventaire = Inventaire.getInstance();
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
        return "plats.PlatCommande{ Etat du plat =  Commande }";
    }
}
