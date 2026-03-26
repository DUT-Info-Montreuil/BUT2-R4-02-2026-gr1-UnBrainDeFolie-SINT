package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario nominal : questionnairesDisponibles retourne une liste peuplée.
 *
 * Scénario couvert (plan de test §questionnairesDisponibles – cas 1) :
 *   "Cette méthode consiste à appeler fournirListeQuestionnaires, de traiter
 *    cette liste afin de récupérer nbQuestionsSimples, nbQuestionsIntermediaires,
 *    nbQuestionsDifficiles, le libellé et l'idQuestionnaire, puis les mettre
 *    dans QuestionnaireDispoDTO via ses setters."
 */
public class QuestionnairesDisponiblesMock implements ISINTServiceQuizz {

    @Override
    public ArrayList<JoueurDTO> joueursDisponibles()
            throws JoueursInexistantsException, ErreurChargementJoueurException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }

    @Override
    public ArrayList<QuestionnaireDispoDTO> questionnairesDisponibles()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        ArrayList<QuestionnaireDispoDTO> questionnaires = new ArrayList<>();

        QuestionnaireDispoDTO q1 = new QuestionnaireDispoDTO();
        q1.setIdQuestionnaire(1);
        q1.setlibelle("Culture générale");        // setlibelle : minuscule intentionnelle
        q1.setNbQuestionsSimples(5);
        q1.setNbQuestionsIntermediaires(3);
        q1.setNbQuestionsDifficiles(2);

        QuestionnaireDispoDTO q2 = new QuestionnaireDispoDTO();
        q2.setIdQuestionnaire(2);
        q2.setlibelle("Histoire");
        q2.setNbQuestionsSimples(4);
        q2.setNbQuestionsIntermediaires(4);
        q2.setNbQuestionsDifficiles(2);

        questionnaires.add(q1);
        questionnaires.add(q2);

        return questionnaires;
    }

    @Override
    public ElementsDisponiblesDTO elementsDispo()
            throws ElementInexistantException, ErreurChargementException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }
}