package universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos;

import universite_Paris8.iut.qdev.tp2026.gr1.utils.QuestionnaireDTO;

import java.util.List;

/**
 * DTO (Data Transfer Object) représentant les questionnaires disponibles,
 * avec le nombre de questions par niveau de difficulté ainsi que
 * la liste des questionnaires disponibles sous forme de QuestionnaireDTO.
 */
public class QuestionnairesDispoDTO {

    private int nbQuestionsSimples;
    private int nbQuestionsIntermediaires;
    private int nbQuestionsDifficiles;
    private List<QuestionnaireDTO> listeQuestionnairesDispo;

    // Constructeur complet
    public QuestionnairesDispoDTO(int nbQuestionsSimples, int nbQuestionsIntermediaires,
                                  int nbQuestionsDifficiles, List<QuestionnaireDTO> listeQuestionnairesDispo) {
        this.nbQuestionsSimples = nbQuestionsSimples;
        this.nbQuestionsIntermediaires = nbQuestionsIntermediaires;
        this.nbQuestionsDifficiles = nbQuestionsDifficiles;
        this.listeQuestionnairesDispo = listeQuestionnairesDispo;
    }

    // Constructeur vide
    public QuestionnairesDispoDTO() {}

    // Getters / Setters
    public int getNbQuestionsSimples() {
        return nbQuestionsSimples;
    }

    public void setNbQuestionsSimples(int nbQuestionsSimples) {
        this.nbQuestionsSimples = nbQuestionsSimples;
    }

    public int getNbQuestionsIntermediaires() {
        return nbQuestionsIntermediaires;
    }

    public void setNbQuestionsIntermediaires(int nbQuestionsIntermediaires) {
        this.nbQuestionsIntermediaires = nbQuestionsIntermediaires;
    }

    public int getNbQuestionsDifficiles() {
        return nbQuestionsDifficiles;
    }

    public void setNbQuestionsDifficiles(int nbQuestionsDifficiles) {
        this.nbQuestionsDifficiles = nbQuestionsDifficiles;
    }

    public List<QuestionnaireDTO> getListeQuestionnairesDispo() {
        return listeQuestionnairesDispo;
    }

    public void setListeQuestionnairesDispo(List<QuestionnaireDTO> listeQuestionnairesDispo) {
        this.listeQuestionnairesDispo = listeQuestionnairesDispo;
    }

    // ToString
    @Override
    public String toString() {
        return "QuestionnairesDispoDTO{" +
                "nbQuestionsSimples=" + nbQuestionsSimples +
                ", nbQuestionsIntermediaires=" + nbQuestionsIntermediaires +
                ", nbQuestionsDifficiles=" + nbQuestionsDifficiles +
                ", listeQuestionnairesDispo=" + listeQuestionnairesDispo +
                '}';
    }
}