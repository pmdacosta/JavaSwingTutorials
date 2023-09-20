package data;

public class FormData {
	private String name;
	private String occupation;
	private String taxID;
	private boolean isUsCitizen;
	private EmploymentCategory employmentCategory;
	private AgeCategory ageCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public boolean isUsCitizen() {
		return isUsCitizen;
	}

	public void isUsCitizen(boolean usCitizen) {
		this.isUsCitizen = usCitizen;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
		if(taxID.trim().isEmpty()) {
			this.taxID = "N/A";
		}
		
	}

	public EmploymentCategory getEmploymentCategory() {
		return employmentCategory;
	}

	public void setEmploymentCategory(EmploymentCategory employmentCategory) {
		this.employmentCategory = employmentCategory;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

}
