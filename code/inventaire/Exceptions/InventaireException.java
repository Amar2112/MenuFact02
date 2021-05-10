package inventaire.Exceptions;

public class InventaireException extends Exception{
    public InventaireException(String message){
        super("MenuException: " + message);
    }
}
