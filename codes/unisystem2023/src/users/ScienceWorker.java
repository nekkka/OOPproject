package users;

public class ScienceWorker extends Employee implements CanBeResearcher{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ScienceWorker() {
        super();
    }
    public ScienceWorker(String login, String password){
		super(login, password);
	}

	@Override
	public Researcher becomeResearcher(){
		return new Researcher(this);
	}

}
