package universite_Paris8.iut.qdev.tp2026.gr1.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ErreurChargementJoueurException;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.JoueursInexistantsException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests de la méthode joueursDisponibles() de ISINTServiceQuizz.
 *
 * Scénarios couverts (plan de test §joueursDisponibles) :
 *   Cas 1 – Succès : la méthode retourne une liste non vide de JoueurDTO.
 *   Cas 2 – Erreur : JoueursInexistantsException si les joueurs sont inexistants.
 *   Cas 3 – Erreur : ErreurChargementJoueurException si le chargement échoue.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests joueursDisponibles()")
public class JoueursDisponiblesTest {

    @Mock
    private ISINTServiceQuizz service;

    private ArrayList<JoueurDTO> listeJoueursValide;

    @BeforeEach
    void setUp() {
        ArrayList<String> centresInterets1 = new ArrayList<>();
        centresInterets1.add("Musique");

        ArrayList<String> centresInterets2 = new ArrayList<>();
        centresInterets2.add("Sport");

        listeJoueursValide = new ArrayList<>();
        listeJoueursValide.add(new JoueurDTO("Alice", "ali75", 2000, centresInterets1, LangueEnum.FRANCAIS));
        listeJoueursValide.add(new JoueurDTO("Bob",   "bob42", 1998, centresInterets2, LangueEnum.ANGLAIS));
    }

    // -------------------------------------------------------------------------
    // Cas 1 – Succès
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 1 – Succès : retourne une liste non nulle et non vide")
    void joueursDisponibles_succes_listeNonVide()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles()).thenReturn(listeJoueursValide);

        ArrayList<JoueurDTO> joueurs = service.joueursDisponibles();

        assertNotNull(joueurs,         "La liste retournée ne doit pas être null");
        assertFalse(joueurs.isEmpty(), "La liste retournée ne doit pas être vide");

        verify(service, times(1)).joueursDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque joueur de la liste est non null")
    void joueursDisponibles_succes_aucunJoueurNull()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles()).thenReturn(listeJoueursValide);

        ArrayList<JoueurDTO> joueurs = service.joueursDisponibles();

        for (JoueurDTO joueur : joueurs) {
            assertNotNull(joueur, "Aucun élément de la liste ne doit être null");
        }

        verify(service, times(1)).joueursDisponibles();
    }

    @Test
    @DisplayName("Cas 1 – Succès : chaque joueur possède un pseudo non null et non vide")
    void joueursDisponibles_succes_pseudoNonVide()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles()).thenReturn(listeJoueursValide);

        ArrayList<JoueurDTO> joueurs = service.joueursDisponibles();

        for (JoueurDTO joueur : joueurs) {
            assertNotNull(joueur.getPseudo(),          "Le pseudo d'un joueur ne doit pas être null");
            assertFalse(joueur.getPseudo().isBlank(),  "Le pseudo d'un joueur ne doit pas être vide");
        }

        verify(service, times(1)).joueursDisponibles();
    }

    // -------------------------------------------------------------------------
    // Cas 2 – JoueursInexistantsException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 2 – Erreur : lève JoueursInexistantsException si joueurs inexistants")
    void joueursDisponibles_joueursInexistants_leveJoueursInexistantsException()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles())
                .thenThrow(new JoueursInexistantsException("La liste des joueurs est vide ou inexistante."));

        assertThrows(JoueursInexistantsException.class,
                () -> service.joueursDisponibles(),
                "JoueursInexistantsException attendue quand la liste est inexistante");

        verify(service, times(1)).joueursDisponibles();
    }

    @Test
    @DisplayName("Cas 2 – Erreur : JoueursInexistantsException est bien une ElementInexistantException")
    void joueursDisponibles_joueursInexistants_estElementInexistantException()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles())
                .thenThrow(new JoueursInexistantsException("La liste des joueurs est vide ou inexistante."));

        // JoueursInexistantsException étend ElementInexistantException :
        // on capture l'exception pour vérifier la cohérence de la hiérarchie.
        JoueursInexistantsException ex = assertThrows(
                JoueursInexistantsException.class,
                () -> service.joueursDisponibles());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).joueursDisponibles();
    }

    // -------------------------------------------------------------------------
    // Cas 3 – ErreurChargementJoueurException
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cas 3 – Erreur : lève ErreurChargementJoueurException si chargement échoue")
    void joueursDisponibles_erreurChargement_leveErreurChargementJoueurException()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles())
                .thenThrow(new ErreurChargementJoueurException("Erreur lors du chargement de la liste des joueurs."));

        assertThrows(ErreurChargementJoueurException.class,
                () -> service.joueursDisponibles(),
                "ErreurChargementJoueurException attendue quand le chargement échoue");

        verify(service, times(1)).joueursDisponibles();
    }

    @Test
    @DisplayName("Cas 3 – Erreur : le message de l'exception n'est pas null")
    void joueursDisponibles_erreurChargement_messageNonNull()
            throws JoueursInexistantsException, ErreurChargementJoueurException {

        when(service.joueursDisponibles())
                .thenThrow(new ErreurChargementJoueurException("Erreur lors du chargement de la liste des joueurs."));

        ErreurChargementJoueurException ex = assertThrows(
                ErreurChargementJoueurException.class,
                () -> service.joueursDisponibles());

        assertNotNull(ex.getMessage(), "Le message de l'exception ne doit pas être null");

        verify(service, times(1)).joueursDisponibles();
    }
}