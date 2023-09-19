package events;

public class FormEvent {
	
	private String name;
	private String occupation;

	public FormEvent(String name, String occupation) {
		this.name = name;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

}
