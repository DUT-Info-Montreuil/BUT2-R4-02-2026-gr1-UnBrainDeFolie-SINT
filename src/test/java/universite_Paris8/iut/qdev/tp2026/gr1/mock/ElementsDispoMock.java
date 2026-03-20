package universite_Paris8.iut.qdev.tp2026.gr1.mock;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Mock scénario nominal : elementsDispo retourne un ElementsDisponiblesDTO peuplé.
 *
 * Scénario couvert (plan de test §elementsDispo – cas 1) :
 *   "Cette méthode consiste à appeler questionnairesDisponibles et joueursDisponibles
 *    afin de récupérer les listes, puis créer un objet ElementsDisponiblesDTO
 *    via ses setters."
 *
 * Note : ElementsDisponiblesDTO agrège directement ArrayList<JoueurDTO>
 * et ArrayList<QuestionnaireDispoDTO> (pas de QuestionnairesDispoDTO intermédiaire).
 */
public class ElementsDispoMock implements ISINTServiceQuizz {

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

        // --- Joueurs ---
        ArrayList<String> centresInterets1 = new ArrayList<>();
        centresInterets1.add("Cinéma");

        ArrayList<String> centresInterets2 = new ArrayList<>();
        centresInterets2.add("Lecture");

        ArrayList<JoueurDTO> joueurs = new ArrayList<>();
        joueurs.add(new JoueurDTO("Alice", "ali75", 2000, centresInterets1, LangueEnum.FRANCAIS));
        joueurs.add(new JoueurDTO("Bob",   "bob42", 1998, centresInterets2, LangueEnum.ANGLAIS));

        // --- Questionnaires ---
        QuestionnaireDispoDTO q1 = new QuestionnaireDispoDTO();
        q1.setIdQuestionnaire(1);
        q1.setlibelle("Culture générale");   // setlibelle : minuscule intentionnelle
        q1.setNbQuestionsSimples(5);
        q1.setNbQuestionsIntermediaires(3);
        q1.setNbQuestionsDifficiles(2);

        ArrayList<QuestionnaireDispoDTO> questionnaires = new ArrayList<>();
        questionnaires.add(q1);

        // --- Assemblage ---
        ElementsDisponiblesDTO elements = new ElementsDisponiblesDTO();
        elements.setJoueurs(joueurs);
        elements.setQuestionnaires(questionnaires);

        return elements;
    }
}