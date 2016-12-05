/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class MedicationAdministration {

	private String dosage;
	private String time;
	private String medication;
	private String practitioner;
	private String prescription;
	private String reason;
	public String html;

	public MedicationAdministration(
			ca.uhn.fhir.model.dstu2.resource.MedicationAdministration medicationAdministration) {
		html = medicationAdministration.getText().getDivAsString();
		medicationAdministration.getDosage().getText();
		medicationAdministration.getEffectiveTime().toString();
		medicationAdministration.getMedication().toString();
		medicationAdministration.getPractitioner().getDisplayElement().getValue();
		medicationAdministration.getPrescription().getDisplayElement().getValue();
		medicationAdministration.getReasonGiven().get(0).getText();
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getPractitioner() {
		return practitioner;
	}

	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
