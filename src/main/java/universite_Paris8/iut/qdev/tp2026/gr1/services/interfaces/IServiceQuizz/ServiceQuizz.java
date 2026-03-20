package universite_Paris8.iut.qdev.tp2026.gr1.services;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.ElementsDisponiblesDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.QuestionnaireDispoDTO;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceJoueur;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz.ISINTServiceQuizz;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Implémentation de l'interface ISINTServiceQuizz.
 * Fournit les méthodes pour récupérer les joueurs et questionnaires disponibles.
 */
public class ServiceQuizz implements ISINTServiceQuizz {

    private ArrayList<JoueurDTO> joueurs;
    private ArrayList<QuestionnaireDispoDTO> questionnaires;

    public ServiceQuizz() {

    }

    /**
     * Retourne la liste de tous les joueurs disponibles.
     *
     * @return ArrayList contenant les joueurs disponibles
     * @throws JoueursInexistantsException       si la liste des joueurs est vide ou inexistante
     * @throws ErreurChargementJoueurException   si un joueur dans la liste est null
     */
    @Override
    public ArrayList<JoueurDTO> joueursDisponibles() throws JoueursInexistantsException, ErreurChargementJoueurException {

        if (joueurs == null || joueurs.isEmpty()) {
            throw new JoueursInexistantsException("Aucun joueur disponible dans le système.");
        }

        for (JoueurDTO joueur : joueurs) {
            if (joueur == null) {
                throw new ErreurChargementJoueurException("Erreur lors du chargement : un joueur est null.");
            }
        }

        return joueurs;
    }

    /**
     * Retourne la liste de tous les questionnaires disponibles.
     *
     * @return ArrayList contenant les questionnaires disponibles
     * @throws QuestionnairesInexistantsException        si la liste des questionnaires est vide ou inexistante
     * @throws ErreurChargementQuestionnairesException   si un questionnaire dans la liste est null
     */
    @Override
    public ArrayList<QuestionnaireDispoDTO> questionnairesDisponibles() throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {
        if (questionnaires == null || questionnaires.isEmpty()) {
            throw new QuestionnairesInexistantsException("Aucun questionnaire disponible dans le système.");
        }

        for (QuestionnaireDispoDTO questionnaire : questionnaires) {
            if (questionnaire == null) {
                throw new ErreurChargementQuestionnairesException("Erreur lors du chargement : un questionnaire est null.");
            }
        }

        return questionnaires;
    }

    /**
     * Retourne un objet regroupant l'ensemble des éléments disponibles,
     * c'est-à-dire la liste des joueurs et les questionnaires disponibles.
     *
     * @return ElementsDisponiblesDTO contenant les joueurs et les questionnaires disponibles
     * @throws ElementInexistantException   si une des listes est vide ou inexistante
     * @throws ErreurChargementException    si un des éléments est null
     */
    @Override
    public ElementsDisponiblesDTO elementsDispo() throws ElementInexistantException, ErreurChargementException {

        ArrayList<JoueurDTO> joueursDispos;
        ArrayList<QuestionnaireDispoDTO> questionnairesDispos;

        try {
            joueursDispos = joueursDisponibles();
        } catch (JoueursInexistantsException e) {
            throw new ElementInexistantException("Liste des joueurs vide ou inexistante : " + e.getMessage());
        } catch (ErreurChargementJoueurException e) {
            throw new ErreurChargementException("Erreur de chargement d'un joueur : " + e.getMessage());
        }

        try {
            questionnairesDispos = questionnairesDisponibles();
        } catch (QuestionnairesInexistantsException e) {
            throw new ElementInexistantException("Liste des questionnaires vide ou inexistante : " + e.getMessage());
        } catch (ErreurChargementQuestionnairesException e) {
            throw new ErreurChargementException("Erreur de chargement d'un questionnaire : " + e.getMessage());
        }

        return new ElementsDisponiblesDTO(joueursDispos, questionnairesDispos);
    }
}