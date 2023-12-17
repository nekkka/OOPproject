package users;

import java.util.List;

import unisystem2023.CanBeResearcher;

public class PhDStudent extends Student implements CanBeResearcher {
    
    private Researcher researchSupervisor;
    private List<ResearchPapers> works;

    public Researcher getResearchSupervisor() {
        return this.researchSupervisor;
    }
    
    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }
    
    public List<ResearchPapers> getWorks() {
        return this.works;
    }

    public void setWorks(List<ResearchPapers> works) {
        this.works = works;
    }

    public void teachAsPracticant() {
        // TODO: Implement method for teaching as a practicant
    }
    
    public String writeDiploma() {
        // TODO: Implement method for writing diploma
        return ""; // Placeholder return statement, modify as per implementation
    }
}
