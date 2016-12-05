/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class Procedure {

	public String bodySite;
	public String category;
	public String complication;
	public String followUp;
	public String location;
	public String outcome;
	public String performer;
	public String reason;
	public String html;

	public Procedure(ca.uhn.fhir.model.dstu2.resource.Procedure procedure) {
		html = procedure.getText().getDivAsString();
		procedure.getBodySite().get(0).getText();
		procedure.getCategory().getText();
		procedure.getComplicationFirstRep().getText();
		procedure.getFollowUpFirstRep().getText();
		procedure.getLocation().getDisplayElement().getValue();
		procedure.getOutcome().getText();
		procedure.getPerformer().get(0).getActor().getDisplayElement().getValue();
		procedure.getReason().toString();
	}

	public String getBodySite() {
		return bodySite;
	}

	public void setBodySite(String bodySite) {
		this.bodySite = bodySite;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComplication() {
		return complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	public String getFollowUp() {
		return followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
