package events;

import data.FormData;

public class FormEvent {

	private FormData data;

	public FormEvent(FormData data) {
		this.data = data;
	}

	public String getAllData() {
		StringBuilder string = new StringBuilder();
		string.append(String.format("%-20s%-20s\n", "Name", data.getName()));
		string.append(String.format("%-20s%-20s\n", "Occupation", data.getOccupation()));
		string.append(String.format("%-20s%-20s\n", "Age", data.getAgeCategory().getId()));
		string.append(String.format("%-20s%-20s\n", "Employment", data.getEmploymentCategory().getId()));
		string.append(String.format("%-20s%-20s\n", "US Citizen", data.isUsCitizen() ? "YES" : "NO"));
		string.append(String.format("%-20s%-20s\n", "Tax ID", data.getTaxID()));
		string.append(String.format("%-20s%-20s\n", "Gender", data.getGender()));
		return string.toString();
	}
}
