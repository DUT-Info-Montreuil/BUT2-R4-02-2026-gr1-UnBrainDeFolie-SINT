package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception levée lorsque la liste des questionnaires est vide ou inexistante.
 * Hérite de ElementInexistantException et fournit un message par défaut
 * adapté au contexte des questionnaires.
 */
public class QuestionnairesInexistantsException extends ElementInexistantException {

    public QuestionnairesInexistantsException() {
        super("La liste des questionnaires est inexistante.");
    }

    public QuestionnairesInexistantsException(String message) {
        super(message);
    }
}