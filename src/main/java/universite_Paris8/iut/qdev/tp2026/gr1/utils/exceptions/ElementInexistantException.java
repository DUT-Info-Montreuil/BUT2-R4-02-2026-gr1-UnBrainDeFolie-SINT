package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception mère représentant le cas où un élément demandé est inexistant,
 * c'est-à-dire que la liste correspondante est vide ou nulle.
 * Cette classe sert de base aux exceptions spécialisées pour chaque type d'élément.
 */
public class ElementInexistantException extends Exception {

    public ElementInexistantException(String message) {
        super(message);
    }

    public ElementInexistantException(String message, Throwable cause) {
        super(message, cause);
    }
}