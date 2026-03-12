package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception levée lorsqu'un questionnaire demandé est null.
 * Hérite de ElementNullException et fournit un message par défaut
 * adapté au contexte des questionnaires.
 */
public class ErreurChargementQuestionnairesException extends ErreurChargementException {

    public ErreurChargementQuestionnairesException() {
        super("Le questionnaire demandé est null ou n'a pas été initialisé.");
    }

    public ErreurChargementQuestionnairesException(String message) {
        super(message);
    }
}