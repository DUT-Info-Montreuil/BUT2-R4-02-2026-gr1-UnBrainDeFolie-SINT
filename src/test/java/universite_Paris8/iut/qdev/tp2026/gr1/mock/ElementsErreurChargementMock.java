package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario d'erreur : elementsDispo lève ErreurChargementException.
 *
 * Scénario couvert (plan de test §elementsDispo – cas 3) :
 *   "Cette méthode doit renvoyer une erreur ErreurChargementException
 *    si une erreur est présente après la lecture/chargement d'une des 2 listes."
 */
public class ElementsErreurChargementMock implements ISINTServiceQuizz {

    @Override
    public ArrayList<JoueurDTO> joueursDisponibles()
            throws JoueursInexistantsException, ErreurChargementJoueurException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }

    @Override
    public ArrayList<QuestionnaireDispoDTO> questionnairesDisponibles()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {
        throw new UnsupportedOperationException("Hors scope de ce scénario");
    }

    @Override
    public ElementsDisponiblesDTO elementsDispo()
            throws ElementInexistantException, ErreurChargementException {
        throw new ErreurChargementException(
                "Erreur lors du chargement d'une des listes (joueurs ou questionnaires).");
    }
}