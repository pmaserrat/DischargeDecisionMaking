/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class Condition {

	public String abatement;
	public String asserter;
	public String bodySite;
	public String clinicalStatus;
	public String date;
	public String evidence;
	public String resourceName;
	public String verificationStatus;
	public String stage;
	public String notes;

	public Condition(ca.uhn.fhir.model.dstu2.resource.Condition condition) {
		condition.getAbatement().toString();
		condition.getAsserter().getDisplayElement().getValue();
		condition.getBodySiteFirstRep().getText();
		condition.getClinicalStatus();
		condition.getDateRecorded().toString();
		condition.getEvidenceFirstRep().toString();
		condition.getResourceName().toString();
		condition.getVerificationStatus().toString();
		condition.getStage().getSummary().getText();
		condition.getNotes();
	}

	public String getAbatement() {
		return abatement;
	}

	public void setAbatement(String abatement) {
		this.abatement = abatement;
	}

	public String getAsserter() {
		return asserter;
	}

	public void setAsserter(String asserter) {
		this.asserter = asserter;
	}

	public String getBodySite() {
		return bodySite;
	}

	public void setBodySite(String bodySite) {
		this.bodySite = bodySite;
	}

	public String getClinicalStatus() {
		return clinicalStatus;
	}

	public void setClinicalStatus(String clinicalStatus) {
		this.clinicalStatus = clinicalStatus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
