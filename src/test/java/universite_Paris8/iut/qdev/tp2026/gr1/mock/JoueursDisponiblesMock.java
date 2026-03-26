package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario nominal : joueursDisponibles retourne une liste peuplée.
 *
 * Scénario couvert (plan de test §joueursDisponibles – cas 1) :
 *   "Cette méthode consiste à appeler listerJoueurs puis renvoyer la liste."
 */
public class JoueursDisponiblesMock implements ISINTServiceQuizz {

    @Override
    public ArrayList<JoueurDTO> joueursDisponibles()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        ArrayList<String> centresInterets1 = new ArrayList<>();
        centresInterets1.add("Musique");

        ArrayList<String> centresInterets2 = new ArrayList<>();
        centresInterets2.add("Sport");

        ArrayList<JoueurDTO> joueurs = new ArrayList<>();
        joueurs.add(new JoueurDTO("Alice", "ali75", 2000, centresInterets1, LangueEnum.FRANCAIS));
        joueurs.add(new JoueurDTO("Bob",   "bob42", 1998, centresInterets2, LangueEnum.ANGLAIS));

        return joueurs;
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