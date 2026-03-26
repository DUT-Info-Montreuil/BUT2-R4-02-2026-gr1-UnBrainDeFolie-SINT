package universite_Paris8.iut.qdev.tp2026.gr1.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ErreurChargementQuestionnairesException;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.QuestionnairesInexistantsException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests de la méthode questionnairesDisponibles() de ISINTServiceQuizz.
 *
 * Scénarios couverts (plan de test §questionnairesDisponibles) :
 *   Cas 1 – Succès : la méthode retourne une liste non vide de QuestionnaireDispoDTO
 *            avec nbQuestionsSimples, nbQuestionsIntermediaires, nbQuestionsDifficiles,
 *            libelle et idQuestionnaire correctement renseignés.
 *   Cas 2 – Erreur : QuestionnairesInexistantsException si les questionnaires sont inexistants.
 *   Cas 3 – Erreur : ErreurChargementQuestionnairesException si le chargement échoue.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests questionnairesDisponibles()")
public class QuestionnairesDisponiblesTest {

    @Mock
    private ISINTServiceQuizz service;

    private ArrayList<QuestionnaireDispoDTO> listeQuestionnairesValide;

    @BeforeEach
    void setUp() {
        QuestionnaireDispoDTO q1 = new QuestionnaireDispoDTO();
        q1.setIdQuestionnaire(1);
        q1.setlibelle("Culture générale");
        q1.setNbQuestionsSimples(5);
        q1.setNbQuestionsIntermediaires(3);
        q1.setNbQuestionsDifficiles(2);

        QuestionnaireDispoDTO q2 = new QuestionnaireDispoDTO();
        q2.setIdQuestionnaire(2);
        q2.setlibelle("Histoire");
        q2.setNbQuestionsSimples(4);
        q2.setNbQuestionsIntermediaires(4);
        q2.setNbQuestionsDifficiles(2);

        listeQuestionnairesValide = new ArrayList<>();
        listeQuestionnairesValide.add(q1);
        listeQuestionnairesValide.add(q2);
    }

    // -------------------------------------------------------------------------
    // Cas 1 – Succès
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 1 – Succès : retourne une liste non nulle et non vide")
    void questionnairesDisponibles_succes_listeNonVide()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles()).thenReturn(listeQuestionnairesValide);

        ArrayList<QuestionnaireDispoDTO> questionnaires = service.questionnairesDisponibles();

        assertNotNull(questionnaires,          "La liste retournée ne doit pas être null");
        assertFalse(questionnaires.isEmpty(),  "La liste retournée ne doit pas être vide");

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque QuestionnaireDispoDTO est non null")
    void questionnairesDisponibles_succes_aucunQuestionnaireNull()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles()).thenReturn(listeQuestionnairesValide);

        ArrayList<QuestionnaireDispoDTO> questionnaires = service.questionnairesDisponibles();

        for (QuestionnaireDispoDTO q : questionnaires) {
            assertNotNull(q, "Aucun élément de la liste ne doit être null");
        }

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque questionnaire a un libelle non null et non vide")
    void questionnairesDisponibles_succes_libelleNonVide()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles()).thenReturn(listeQuestionnairesValide);

        ArrayList<QuestionnaireDispoDTO> questionnaires = service.questionnairesDisponibles();

        for (QuestionnaireDispoDTO q : questionnaires) {
            assertNotNull(q.getlibelle(),         "Le libelle d'un questionnaire ne doit pas être null");
            assertFalse(q.getlibelle().isBlank(), "Le libelle d'un questionnaire ne doit pas être vide");
        }

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : les compteurs de questions sont tous >= 0")
    void questionnairesDisponibles_succes_compteursPositifsOuNuls()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles()).thenReturn(listeQuestionnairesValide);

        ArrayList<QuestionnaireDispoDTO> questionnaires = service.questionnairesDisponibles();

        for (QuestionnaireDispoDTO q : questionnaires) {
            assertTrue(q.getNbQuestionsSimples()        >= 0, "nbQuestionsSimples doit être >= 0");
            assertTrue(q.getNbQuestionsIntermediaires() >= 0, "nbQuestionsIntermediaires doit être >= 0");
            assertTrue(q.getNbQuestionsDifficiles()     >= 0, "nbQuestionsDifficiles doit être >= 0");
        }

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque questionnaire a un idQuestionnaire > 0")
    void questionnairesDisponibles_succes_idPositif()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles()).thenReturn(listeQuestionnairesValide);

        ArrayList<QuestionnaireDispoDTO> questionnaires = service.questionnairesDisponibles();

        for (QuestionnaireDispoDTO q : questionnaires) {
            assertTrue(q.getIdQuestionnaire() > 0, "L'idQuestionnaire doit être > 0");
        }

        verify(service, times(1)).questionnairesDisponibles();
    }

    // -------------------------------------------------------------------------
    // Cas 2 – QuestionnairesInexistantsException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 2 – Erreur : lève QuestionnairesInexistantsException si questionnaires inexistants")
    void questionnairesDisponibles_questionnairesInexistants_leveQuestionnairesInexistantsException()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles())
                .thenThrow(new QuestionnairesInexistantsException("La liste des questionnaires est vide ou inexistante."));

        assertThrows(QuestionnairesInexistantsException.class,
                () -> service.questionnairesDisponibles(),
                "QuestionnairesInexistantsException attendue quand la liste est inexistante");

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 2 – Erreur : le message de l'exception n'est pas null")
    void questionnairesDisponibles_questionnairesInexistants_messageNonNull()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles())
                .thenThrow(new QuestionnairesInexistantsException("La liste des questionnaires est vide ou inexistante."));

        QuestionnairesInexistantsException ex = assertThrows(
                QuestionnairesInexistantsException.class,
                () -> service.questionnairesDisponibles());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).questionnairesDisponibles();
    }

    // -------------------------------------------------------------------------
    // Cas 3 – ErreurChargementQuestionnairesException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 3 – Erreur : lève ErreurChargementQuestionnairesException si chargement échoue")
    void questionnairesDisponibles_erreurChargement_leveErreurChargementQuestionnairesException()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles())
                .thenThrow(new ErreurChargementQuestionnairesException("Erreur lors du chargement de la liste des questionnaires."));

        assertThrows(ErreurChargementQuestionnairesException.class,
                () -> service.questionnairesDisponibles(),
                "ErreurChargementQuestionnairesException attendue quand le chargement échoue");

        verify(service, times(1)).questionnairesDisponibles();
    }

    @Test
    @DisplayName("Cas 3 – Erreur : le message de l'exception n'est pas null")
    void questionnairesDisponibles_erreurChargement_messageNonNull()
            throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        when(service.questionnairesDisponibles())
                .thenThrow(new ErreurChargementQuestionnairesException("Erreur lors du chargement de la liste des questionnaires."));

        ErreurChargementQuestionnairesException ex = assertThrows(
                ErreurChargementQuestionnairesException.class,
                () -> service.questionnairesDisponibles());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).questionnairesDisponibles();
    }
}