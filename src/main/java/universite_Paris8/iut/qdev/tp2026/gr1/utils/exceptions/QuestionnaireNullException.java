package universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions;

/**
 * Exception levée lorsqu'un questionnaire demandé est null.
 * Hérite de ElementNullException et fournit un message par défaut
 * adapté au contexte des questionnaires.
 */
public class QuestionnaireNullException extends ElementNullException {

    public QuestionnaireNullException() {
        super("Le questionnaire demandé est null ou n'a pas été initialisé.");
    }

    public QuestionnaireNullException(String message) {
        super(message);
    }
}