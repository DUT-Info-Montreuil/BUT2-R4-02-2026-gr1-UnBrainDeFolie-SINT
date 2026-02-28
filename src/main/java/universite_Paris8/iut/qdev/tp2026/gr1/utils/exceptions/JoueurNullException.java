package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception levée lorsqu'un joueur demandé est null.
 * Hérite de ElementNullException et fournit un message par défaut
 * adapté au contexte des joueurs.
 */
public class JoueurNullException extends ElementNullException {

    public JoueurNullException() {
        super("Le joueur demandé est null ou n'a pas été initialisé.");
    }

    public JoueurNullException(String message) {
        super(message);
    }
}