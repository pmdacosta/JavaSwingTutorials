package events;

public class FormEvent {
	
	private String name;
	private String occupation;
	private String ageCategory;

	public FormEvent(String name, String occupation, String ageCategory) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCategory;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getAgeCategory() {
		return ageCategory;
	}
}
