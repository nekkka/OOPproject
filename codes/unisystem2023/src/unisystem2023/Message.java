package unisystem2023;

public class Message {
	private String theme;
	private String text;
	private Employee sender;

	public Message(){
		super();
	}

	public Message(Employee sender, String theme, String text){
		this.sender = sender;
		this.theme = theme;
		this.text = text;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public void setText(String text){
		this.text = text;
	}
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	public String getTheme() {
		return theme;
	}

	public String getText() {
		return text;
	}

	public Employee getSender() {
		return sender;
	}
	
	
	public String toString() {
		return "Message [theme=" + theme + ", sender=" + sender + "]";
	}

	public String getMessage(){
		return "Sender: " + sender + '\n' + theme + '\n' + text;
	}
	
}

