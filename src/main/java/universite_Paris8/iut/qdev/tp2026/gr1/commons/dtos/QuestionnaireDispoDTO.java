package universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos;

/**
 * DTO (Data Transfer Object) représentant les questionnaires disponibles,
 * avec le nombre de questions par niveau de difficulté ainsi que
 * le questionnaires disponible sous forme de QuestionnaireDTO.
 */
public class QuestionnaireDispoDTO {

    private int nbQuestionsSimples;
    private int nbQuestionsIntermediaires;
    private int nbQuestionsDifficiles;
    private String libelle;
    private int idQuestionnaire;

    // Constructeur complet
    public QuestionnaireDispoDTO(int nbQuestionsSimples, int nbQuestionsIntermediaires, int nbQuestionsDifficiles, String libelle, int idQuestionnaire) {
        this.nbQuestionsSimples = nbQuestionsSimples;
        this.nbQuestionsIntermediaires = nbQuestionsIntermediaires;
        this.nbQuestionsDifficiles = nbQuestionsDifficiles;
        this.libelle = libelle;
        this.idQuestionnaire = idQuestionnaire;
    }

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

    public String getlibelle() {
        return libelle;
    }

    public void setlibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }


    // ToString
    @Override
    public String toString() {
        return "QuestionnairesDispoDTO{" +
                "nbQuestionsSimples=" + nbQuestionsSimples +
                ", nbQuestionsIntermediaires=" + nbQuestionsIntermediaires +
                ", nbQuestionsDifficiles=" + nbQuestionsDifficiles +
                ", libelle=" + libelle +
                ", idQuestionnaire=" + idQuestionnaire +
                '}';
    }
}