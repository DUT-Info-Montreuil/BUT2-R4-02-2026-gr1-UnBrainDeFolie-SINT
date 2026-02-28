package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception levée lorsque la liste des joueurs est vide ou inexistante.
 * Hérite de ElementInexistantException et fournit un message par défaut
 * adapté au contexte des joueurs.
 */
public class JoueursInexistantsException extends ElementInexistantException {

    public JoueursInexistantsException() {
        super("La liste des joueurs est vide est inexistante.");
    }

    public JoueursInexistantsException(String message) {
        super(message);
    }
}