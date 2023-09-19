package events;

public class FormEvent {
	
	private String name;
	private String occupation;
	private int ageCategoryID;

	public FormEvent(String name, String occupation, int ageCategoryID) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategoryID = ageCategoryID;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public int getAgeCategoryID() {
		return ageCategoryID;
	}
}
