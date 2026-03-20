package universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos;

import java.util.ArrayList;

/**
 * DTO (Data Transfer Object) représentant l'ensemble des éléments disponibles,
 * regroupant la liste des joueurs ainsi que les questionnaires disponibles
 * avec leurs informations associées.
 */
public class ElementsDisponiblesDTO {

    private ArrayList<JoueurDTO> joueurs;
    private ArrayList<QuestionnaireDispoDTO> questionnaires;

    // Constructeur complet
    public ElementsDisponiblesDTO(ArrayList<JoueurDTO> joueurs, ArrayList<QuestionnaireDispoDTO> questionnaires) {
        this.joueurs = joueurs;
        this.questionnaires = questionnaires;
    }

    // Constructeur vide
    public ElementsDisponiblesDTO() {}

    // Getters / Setters
    public ArrayList<JoueurDTO> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<JoueurDTO> joueurs) {
        this.joueurs = joueurs;
    }

    public ArrayList<QuestionnaireDispoDTO> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(ArrayList<QuestionnaireDispoDTO> questionnaires) {
        this.questionnaires = questionnaires;
    }

    // ToString
    @Override
    public String toString() {
        return "ElementsDisponiblesDTO{" +
                "joueurs=" + joueurs +
                ", questionnaires=" + questionnaires +
                '}';
    }
}