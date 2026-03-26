package universite_Paris8.iut.qdev.tp2026.gr1.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ElementInexistantException;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ErreurChargementException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests de la méthode elementsDispo() de ISINTServiceQuizz.
 *
 * Scénarios couverts (plan de test §elementsDispo) :
 *   Cas 1 – Succès : retourne un ElementsDisponiblesDTO avec les deux listes
 *            (joueurs et questionnaires) non nulles et non vides.
 *   Cas 2 – Erreur : ElementInexistantException si une des listes est inexistante.
 *   Cas 3 – Erreur : ErreurChargementException si le chargement d'une des listes échoue.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests elementsDispo()")
public class ElementsDispoTest {

    @Mock
    private ISINTServiceQuizz service;

    private ElementsDisponiblesDTO elementsValides;

    @BeforeEach
    void setUp() {
        ArrayList<String> centresInterets1 = new ArrayList<>();
        centresInterets1.add("Cinéma");

        ArrayList<String> centresInterets2 = new ArrayList<>();
        centresInterets2.add("Lecture");

        ArrayList<JoueurDTO> joueurs = new ArrayList<>();
        joueurs.add(new JoueurDTO("Alice", "ali75", 2000, centresInterets1, LangueEnum.FRANCAIS));
        joueurs.add(new JoueurDTO("Bob",   "bob42", 1998, centresInterets2, LangueEnum.ANGLAIS));

        QuestionnaireDispoDTO q1 = new QuestionnaireDispoDTO();
        q1.setIdQuestionnaire(1);
        q1.setlibelle("Culture générale");
        q1.setNbQuestionsSimples(5);
        q1.setNbQuestionsIntermediaires(3);
        q1.setNbQuestionsDifficiles(2);

        ArrayList<QuestionnaireDispoDTO> questionnaires = new ArrayList<>();
        questionnaires.add(q1);

        elementsValides = new ElementsDisponiblesDTO();
        elementsValides.setJoueurs(joueurs);
        elementsValides.setQuestionnaires(questionnaires);
    }

    // -------------------------------------------------------------------------
    // Cas 1 – Succès
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 1 – Succès : retourne un objet ElementsDisponiblesDTO non null")
    void elementsDispo_succes_objetNonNull()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo()).thenReturn(elementsValides);

        ElementsDisponiblesDTO elements = service.elementsDispo();

        assertNotNull(elements, "L'objet ElementsDisponiblesDTO retourné ne doit pas être null");

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 1 – Succès : la liste des joueurs est non nulle et non vide")
    void elementsDispo_succes_joueursNonVides()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo()).thenReturn(elementsValides);

        ElementsDisponiblesDTO elements = service.elementsDispo();

        assertNotNull(elements.getJoueurs(),          "La liste des joueurs ne doit pas être null");
        assertFalse(elements.getJoueurs().isEmpty(),  "La liste des joueurs ne doit pas être vide");

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 1 – Succès : la liste des questionnaires est non nulle et non vide")
    void elementsDispo_succes_questionnairesNonVides()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo()).thenReturn(elementsValides);

        ElementsDisponiblesDTO elements = service.elementsDispo();

        assertNotNull(elements.getQuestionnaires(),          "La liste des questionnaires ne doit pas être null");
        assertFalse(elements.getQuestionnaires().isEmpty(),  "La liste des questionnaires ne doit pas être vide");

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque joueur contenu est non null")
    void elementsDispo_succes_aucunJoueurNull()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo()).thenReturn(elementsValides);

        ElementsDisponiblesDTO elements = service.elementsDispo();

        elements.getJoueurs().forEach(joueur ->
                assertNotNull(joueur, "Aucun joueur de la liste ne doit être null"));

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque questionnaire contenu est non null")
    void elementsDispo_succes_aucunQuestionnaireNull()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo()).thenReturn(elementsValides);

        ElementsDisponiblesDTO elements = service.elementsDispo();

        elements.getQuestionnaires().forEach(q ->
                assertNotNull(q, "Aucun questionnaire de la liste ne doit être null"));

        verify(service, times(1)).elementsDispo();
    }

    // -------------------------------------------------------------------------
    // Cas 2 – ElementInexistantException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 2 – Erreur : lève ElementInexistantException si une liste est inexistante")
    void elementsDispo_elementInexistant_leveElementInexistantException()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo())
                .thenThrow(new ElementInexistantException("Une des listes (joueurs ou questionnaires) est inexistante."));

        assertThrows(ElementInexistantException.class,
                () -> service.elementsDispo(),
                "ElementInexistantException attendue quand une des listes est inexistante");

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 2 – Erreur : le message de l'exception n'est pas null")
    void elementsDispo_elementInexistant_messageNonNull()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo())
                .thenThrow(new ElementInexistantException("Une des listes (joueurs ou questionnaires) est inexistante."));

        ElementInexistantException ex = assertThrows(
                ElementInexistantException.class,
                () -> service.elementsDispo());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).elementsDispo();
    }

    // -------------------------------------------------------------------------
    // Cas 3 – ErreurChargementException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 3 – Erreur : lève ErreurChargementException si le chargement échoue")
    void elementsDispo_erreurChargement_leveErreurChargementException()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo())
                .thenThrow(new ErreurChargementException("Erreur lors du chargement d'une des listes."));

        assertThrows(ErreurChargementException.class,
                () -> service.elementsDispo(),
                "ErreurChargementException attendue quand le chargement d'une liste échoue");

        verify(service, times(1)).elementsDispo();
    }

    @Test
    @DisplayName("Cas 3 – Erreur : le message de l'exception n'est pas null")
    void elementsDispo_erreurChargement_messageNonNull()
            throws ElementInexistantException, ErreurChargementException {

        when(service.elementsDispo())
                .thenThrow(new ErreurChargementException("Erreur lors du chargement d'une des listes."));

        ErreurChargementException ex = assertThrows(
                ErreurChargementException.class,
                () -> service.elementsDispo());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).elementsDispo();
    }
}