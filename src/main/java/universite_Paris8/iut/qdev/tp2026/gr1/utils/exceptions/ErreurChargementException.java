package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception mère représentant le cas où un élément demandé est null.
 * Cette classe sert de base aux exceptions spécialisées pour chaque type d'élément
 * lorsque celui-ci n'a pas été correctement initialisé ou est introuvable.
 */
public class ErreurChargementException extends Exception {

    public ErreurChargementException(String message) {
        super(message);
    }

    public ErreurChargementException(String message, Throwable cause) {
        super(message, cause);
    }
}