package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario d'erreur : elementsDispo lève ElementInexistantException.
 *
 * Scénario couvert (plan de test §elementsDispo – cas 2) :
 *   "Cette méthode doit renvoyer une erreur ElementInexistantException
 *    si une des listes est inexistante."
 */
public class ElementsInexistantsMock implements ISINTServiceQuizz {

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
        throw new ElementInexistantException(
                "Une des listes (joueurs ou questionnaires) est inexistante.");
    }
}