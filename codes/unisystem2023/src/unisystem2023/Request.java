package unisystem2023;

import java.io.Serializable;
import java.util.Objects;

import users.Student;


public class Request implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean done = false;
	private Student senderRequest;
	private String text;
	private String topic;

	public Request(){
		super();
	}

	public Request(Student senderRequest, String theme, String text){
		this.senderRequest = senderRequest;
		setTopic(topic);
		setText(text);
	}
	public void setSenderRequest(Student senderRequest) {
		this.senderRequest = senderRequest;
	}
	public void execute() {
		this.done = true;	
	}
	public boolean getExecuted(){
		return done;
	}
	public Student getSenderRequest(){
		return senderRequest;
	}

	public String getTopic(){
		return topic;
	}

	public String getText(){
		return text;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}

	public void setText(String text){
		this.text = text;
	}

	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(done, senderRequest);
		return result;
	}


	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Request other = (Request) obj;

	    // Сравнение поля 'done'
	    if (done != other.done) return false;

	    // Сравнение объектов senderRequest с учетом возможного null
	    if (senderRequest == null && other.senderRequest != null) return false;
	    if (!Objects.equals(senderRequest, other.senderRequest)) return false;

	    return true;
	}


	public String toString() {
		return "Request: is it done?: " + done + ", who is the sender?: " + senderRequest;
	}
	
	
	
}

