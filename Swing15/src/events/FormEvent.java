package events;

public class FormEvent {

	private String name;
	private String occupation;
	private int ageCategoryID;
	private int employmentCategoryID;

	public FormEvent(String name, String occupation, int ageCategoryID, int employmentCategoryID) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategoryID = ageCategoryID;
		this.employmentCategoryID = employmentCategoryID;
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

	public int getEmploymentCategoryID() {
		return employmentCategoryID;
	}

	public String getAllData() {
		StringBuilder string = new StringBuilder();
		string.append(String.format("%-20s%-20s\n", "Name", name));
		string.append(String.format("%-20s%-20s\n", "Occupation", occupation));
		string.append(String.format("%-20s%-20s\n", "Age", ageCategoryID));
		string.append(String.format("%-20s%-20s\n", "Employment", employmentCategoryID));
		return string.toString();
	}
}
