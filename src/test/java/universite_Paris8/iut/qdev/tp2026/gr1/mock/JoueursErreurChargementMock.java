package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario d'erreur : joueursDisponibles lève ErreurChargementJoueurException.
 *
 * Scénario couvert (plan de test §joueursDisponibles – cas 3) :
 *   "Cette méthode doit renvoyer une erreur ErreurChargementJoueurException
 *    si une erreur est présente lors de la lecture/chargement de la liste
 *    des joueurs."
 */
public class JoueursErreurChargementMock implements ISINTServiceQuizz {

    @Override
    public ArrayList<JoueurDTO> joueursDisponibles()
            throws JoueursInexistantsException, ErreurChargementJoueurException {
        throw new ErreurChargementJoueurException(
                "Erreur lors du chargement de la liste des joueurs.");
    }

    @Override
    public ArrayList<QuestionnaireDispoDTO> questionnairesDisponibles()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }

    @Override
    public ElementsDisponiblesDTO elementsDispo()
            throws ElementInexistantException, ErreurChargementException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }
}
