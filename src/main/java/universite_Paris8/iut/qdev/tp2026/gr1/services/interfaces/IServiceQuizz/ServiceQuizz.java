package universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceQuizz;

import universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos.*;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.ISMEQuestionnaire;
import universite_Paris8.iut.qdev.tp2026.gr1.services.interfaces.IServiceJoueur;
import universite_Paris8.iut.qdev.tp2026.gr1.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface ISINTServiceQuizz.
 * Fournit les méthodes pour récupérer les joueurs et questionnaires disponibles.
 */
public class ServiceQuizz implements ISINTServiceQuizz {

    private IServiceJoueur serviceJoueur;
    private ISMEQuestionnaire serviceQuestionnaire;

    public ServiceQuizz(IServiceJoueur serviceJoueur, ISMEQuestionnaire serviceQuestionnaire) {
        this.serviceJoueur = serviceJoueur;
        this.serviceQuestionnaire = serviceQuestionnaire;
    }

    /**
     * Retourne la liste de tous les joueurs disponibles.
     *
     * @return ArrayList contenant les joueurs disponibles
     * @throws JoueursInexistantsException       si la liste des joueurs est vide ou inexistante
     * @throws ErreurChargementJoueurException   si un joueur dans la liste est null
     */
    @Override
    public List<JoueurDTO> joueursDisponibles() throws JoueursInexistantsException, ErreurChargementJoueurException, ListeJoueursException {
        List<JoueurDTO> listeJoueur = this.serviceJoueur.listerJoueurs();
        if (listeJoueur == null || listeJoueur.isEmpty()) {
            throw new JoueursInexistantsException("Aucun joueur disponible dans le système.");
        }

        for (JoueurDTO joueur : listeJoueur) {
            if (joueur == null) {
                throw new ErreurChargementJoueurException("Erreur lors du chargement : un joueur est null.");
            }
        }

        return listeJoueur;
    }

    /**
     * Retourne la liste de tous les questionnaires disponibles.
     *
     * @return ArrayList contenant les questionnaires disponibles
     * @throws QuestionnairesInexistantsException      si la liste des questionnaires est vide ou inexistante
     * @throws ErreurChargementQuestionnairesException si un questionnaire dans la liste est null
     */
    @Override
    public List<QuestionnaireDispoDTO> questionnairesDisponibles() throws QuestionnairesInexistantsException, ErreurChargementQuestionnairesException {

        List<QuestionnaireDTO> questionnaires= this.serviceQuestionnaire.fournirListeQuestionnaires();
        List<QuestionnaireDispoDTO> questionnaireDispoDTOS = new ArrayList<QuestionnaireDispoDTO>();

        int facile = 0;
        int moyenne = 0;
        int difficile = 0;

        for (QuestionnaireDTO j: questionnaires){
            for (QuestionDTO q: j.getQuestions()){
                switch(q.getValeur()){
                    case 0:
                        facile += 1;
                        break;
                    case 1:
                        moyenne += 1;
                        break;
                    case 2:
                        difficile += 1;
                        break;
                }
            }
            questionnaireDispoDTOS.add(new QuestionnaireDispoDTO(facile,moyenne,difficile,j.getLibelle(),j.getIdQuestionnaire()));
            facile = 0;
            moyenne = 0;
            difficile = 0;
        }
        if (questionnaires.isEmpty()) {
            throw new QuestionnairesInexistantsException("Aucun questionnaire disponible dans le système.");
        }

        for (QuestionnaireDispoDTO questionnaire : questionnaireDispoDTOS) {
            if (questionnaire == null) {
                throw new ErreurChargementQuestionnairesException("Erreur lors du chargement : un questionnaire est null.");
            }
        }

        return questionnaireDispoDTOS;
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
            List<JoueurDTO> ListeJoueurs = new ArrayList<JoueurDTO>();
            List<QuestionnaireDispoDTO> ListeQuestionnaire = new ArrayList<>();
        try {
            ListeJoueurs = joueursDisponibles();
        } catch (JoueursInexistantsException | ListeJoueursException e) {
            throw new ElementInexistantException("Liste des joueurs vide ou inexistante : " + e.getMessage());
        } catch (ErreurChargementJoueurException e) {
            throw new ErreurChargementException("Erreur de chargement d'un joueur : " + e.getMessage());
        }

        try {
            ListeQuestionnaire = questionnairesDisponibles();
        } catch (QuestionnairesInexistantsException e) {
            throw new ElementInexistantException("Liste des questionnaires vide ou inexistante : " + e.getMessage());
        } catch (ErreurChargementQuestionnairesException e) {
            throw new ErreurChargementException("Erreur de chargement d'un questionnaire : " + e.getMessage());
        }

        return new ElementsDisponiblesDTO(ListeJoueurs, ListeQuestionnaire);
    }
}