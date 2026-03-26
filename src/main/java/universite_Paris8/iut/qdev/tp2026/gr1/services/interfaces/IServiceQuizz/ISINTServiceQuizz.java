package universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceJoueur;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface définissant les méthodes permettant de récupérer les éléments disponibles
 * dans le système, à savoir la liste des joueurs et la liste des questionnaires.
 * Les méthodes lèvent des exceptions si les listes sont vides ou si les éléments sont null.
 */
public interface ISINTServiceQuizz {

    /**
     * Retourne la liste de tous les joueurs disponibles.
     *
     * @return ArrayList contenant les joueurs disponibles
     * @throws JoueursInexistantsException si la liste des joueurs est vide ou inexistante
     * @throws ErreurChargementJoueurException si un joueur dans la liste est null
     */
    public List<JoueurDTO> joueursDisponibles(IServiceJoueur serviceJoueur) throws JoueursInexistantsException, ErreurChargementJoueurException, ListeJoueursException;

    /**
     * Retourne la liste de tous les questionnaires disponibles.
     *
     * @return ArrayList contenant les questionnaires disponibles
     * @throws QuestionnairesInexistantsException si la liste des questionnaires est vide ou inexistante
     * @throws ErreurChargementQuestionnairesException si un questionnaire dans la liste est null
     */
    public List<QuestionnaireDispoDTO> questionnairesDisponibles() throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException;

    /**
     * Retourne un objet regroupant l'ensemble des éléments disponibles,
     * c'est-à-dire la liste des joueurs et les questionnaires disponibles.
     *
     * @return ElementsDisponiblesDTO contenant les joueurs et les questionnaires disponibles
     * @throws ElementInexistantException si une des listes est vide ou inexistante
     * @throws ErreurChargementException si un des éléments est null
     */
    public ElementsDisponiblesDTO elementsDispo(IServiceJoueur serviceJoueur) throws ElementInexistantException, ErreurChargementException;

}