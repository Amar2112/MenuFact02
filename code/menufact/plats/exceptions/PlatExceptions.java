package menufact.plats.exceptions;

public class PlatExceptions extends Exception{
    public PlatExceptions(String message){
        super("FactureException: " + message);
    }
}
