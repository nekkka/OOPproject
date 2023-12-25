package users;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import enums.OrderStatus;
import enums.UserRole;

public class TechSupportSpecialist extends Employee implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final UserRole role = UserRole.TECHSUPPORTSPECIALIST;
	private boolean availability;
    private Map<String, OrderStatus> tasks;
    private List<String> skills;
    
    public TechSupportSpecialist(String login, String password) {
    	super(login, password);
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Map<String, OrderStatus> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, OrderStatus> tasks) {
        this.tasks = tasks;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    // Methods implementation

    public void changeAvailability(boolean newAvailability) {
        this.availability = newAvailability;
        System.out.println("Availability changed to: " + newAvailability);
    }

    public void addTasks(String taskName, OrderStatus status) {
        tasks.put(taskName, status);
        System.out.println("Task added: " + taskName);
    }

    public void removeTasks(String taskName) {
        if (tasks.containsKey(taskName)) {
            tasks.remove(taskName);
            System.out.println("Task removed: " + taskName);
        } else {
            System.out.println("Task does not exist: " + taskName);
        }
    }

    public void addSkills(String skill) {
        skills.add(skill);
        System.out.println("Skill added: " + skill);
    }

    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            System.out.println("Tasks:");
            for (Map.Entry<String, OrderStatus> entry : tasks.entrySet()) {
                System.out.println("Task: " + entry.getKey() + ", Status: " + entry.getValue());
            }
        }
    }
    public UserRole getRole() {
        return role;
    }

}
