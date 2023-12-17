package users;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Vector;

import unisystem2023.Data;
import unisystem2023.ResearchPaper;


public class Researcher implements Serializable, Comparable <Researcher>{

	private User researcher;
	private Vector <ResearchPaper> researches = new Vector <ResearchPaper>();

	{
		Data.getInstance().addResearcher(this);
	}

	protected Researcher(){}

	public Researcher(User researcher){ 
		this.researcher = researcher;
	}

	public User getDecoratedObject(){
		return researcher;
	}

	public Vector <ResearchPaper> getResearches(){
		return researches;
	}

	public int compareTo(Researcher r){
		if(researches.size() > r.researches.size()){return 1;}
		if(researches.size() < r.researches.size()){return -1;}
		return 0;
	}

	public void addResearch(ResearchPaper researchPaper){
		researches.add(researchPaper);
	}

	public void dropResearch(ResearchPaper researchPaper){
		researches.remove(researchPaper);
	}
	
}

