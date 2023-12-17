package users;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Vector;

import unisystem2023.Database;
import unisystem2023.ResearchPaper;

public class Researcher implements Serializable, Comparable<Researcher> {

    private User researcher;
    private Vector<ResearchPaper> researches = new Vector<>();
    private Integer hIndex;

    {
        Database.getInstance().addResearcher(this);
    }

    public Researcher() {
        super();
        researches = new Vector<>();
        hIndex = 0;
    }

    public Researcher(User researcher) {
        this.researcher = researcher;
    }

    public User getDecoratedObject() {
        return researcher;
    }

    public Vector<ResearchPaper> getResearches() {
        return researches;
    }

    @Override
    public int compareTo(Researcher r) {
        return Integer.compare(this.researches.size(), r.researches.size());
    }

    public void addResearch(ResearchPaper researchPaper) {
        researches.add(researchPaper);
        if (researchPaper.isFinished()) {
            hIndex++;
        }
    }

    public void dropResearch(ResearchPaper researchPaper) {
        researches.remove(researchPaper);
        if (researchPaper.isFinished()) {
            hIndex--;
        }
    }

    public void printPapers(Comparator<ResearchPaper> c) {
        researches.sort(c);
        for (ResearchPaper paper : researches) {
            System.out.println(paper.toString());
        }
    }

    public Integer calculateHIndex() {
        return hIndex;
    }
}
