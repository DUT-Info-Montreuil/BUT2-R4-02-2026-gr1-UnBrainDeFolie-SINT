package universite_Paris8.iut.qdev.tp2026.gr1.commons.dtos;

import universite_Paris8.iut.qdev.tp2026.gr1.utils.JoueurDTO;

import java.util.List;

/**
 * DTO (Data Transfer Object) représentant l'ensemble des éléments disponibles,
 * regroupant la liste des joueurs ainsi que les questionnaires disponibles
 * avec leurs informations associées.
 */
public class ElementsDisponiblesDTO {

    private List<JoueurDTO> joueurs;
    private QuestionnairesDispoDTO questionnaires;

    // Constructeur complet
    public ElementsDisponiblesDTO(List<JoueurDTO> joueurs, QuestionnairesDispoDTO questionnaires) {
        this.joueurs = joueurs;
        this.questionnaires = questionnaires;
    }

    // Constructeur vide
    public ElementsDisponiblesDTO() {}

    // Getters / Setters
    public List<JoueurDTO> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<JoueurDTO> joueurs) {
        this.joueurs = joueurs;
    }

    public QuestionnairesDispoDTO getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(QuestionnairesDispoDTO questionnaires) {
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