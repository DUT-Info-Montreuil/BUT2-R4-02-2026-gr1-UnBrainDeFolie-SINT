package universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnairesDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.QuestionnaireDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ElementInexistantException;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.ElementNullException;

import java.util.ArrayList;

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
     * @throws ElementInexistantException si la liste des joueurs est vide ou inexistante
     * @throws ElementNullException si un joueur dans la liste est null
     */
    public ArrayList<JoueurDTO> joueursDisponibles() throws ElementInexistantException, ElementNullException;

    /**
     * Retourne la liste de tous les questionnaires disponibles.
     *
     * @return ArrayList contenant les questionnaires disponibles
     * @throws ElementInexistantException si la liste des questionnaires est vide ou inexistante
     * @throws ElementNullException si un questionnaire dans la liste est null
     */
    public ArrayList<QuestionnairesDispoDTO> questionnairesDisponibles() throws ElementInexistantException, ElementNullException;

    /**
     * Retourne un objet regroupant l'ensemble des éléments disponibles,
     * c'est-à-dire la liste des joueurs et les questionnaires disponibles.
     *
     * @return ElementsDisponiblesDTO contenant les joueurs et les questionnaires disponibles
     * @throws ElementInexistantException si une des listes est vide ou inexistante
     * @throws ElementNullException si un des éléments est null
     */
    public ElementsDisponiblesDTO elementsDispo(ArrayList<JoueurDTO> joueurDTO,QuestionnairesDispoDTO questionnairesDispoDTO) throws ElementInexistantException, ElementNullException;
}