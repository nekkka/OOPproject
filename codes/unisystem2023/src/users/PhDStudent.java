package users;

import java.util.List;
import unisystem2023.ResearchPaper;

public class PhDStudent extends Student implements CanBeResearcher {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Researcher researchSupervisor;
    private List<ResearchPaper> works;

    public Researcher getResearchSupervisor() {
        return this.researchSupervisor;
    }
    
    public void setResearchSupervisor(Researcher researchSupervisor) {
        this.researchSupervisor = researchSupervisor;
    }
    
    public List<ResearchPaper> getWorks() {
        return this.works;
    }

    public void setWorks(List<ResearchPaper> works) {
        this.works = works;
    }

    public void teachAsPracticant() {
        // TODO: Implement method for teaching as a practicant
    }
    
    public String writeDiploma() {
        // TODO: Implement method for writing diploma
        return ""; // Placeholder return statement, modify as per implementation
    }
    
    public Researcher becomeaResearcher(){
		return new Researcher(this);
	}
}
