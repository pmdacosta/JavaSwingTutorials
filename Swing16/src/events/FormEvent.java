package events;

public class FormEvent {

	private String name;
	private String occupation;
	private int ageCategoryID;
	private int employmentCategoryID;
	private boolean usCitizen;
	private String taxID;

	public FormEvent(String name, String occupation, int ageCategoryID, int employmentCategoryID, boolean usCitizen, String taxID) {
		this.name = name;
		this.occupation = occupation;
		this.ageCategoryID = ageCategoryID;
		this.employmentCategoryID = employmentCategoryID;
		this.usCitizen = usCitizen;
		this.taxID = taxID;
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
		string.append(String.format("%-20s%-20s\n", "US Citizen", usCitizen ? "YES" : "NO"));
		string.append(String.format("%-20s%-20s\n", "Tax ID", taxID));
		return string.toString();
	}
}
