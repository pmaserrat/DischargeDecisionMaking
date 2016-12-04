/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class Observation {

	private String comment;
	private String specimen;
	private String status;
	private String interpretation;
	private String encounter;
	private String html;
	public Observation(ca.uhn.fhir.model.dstu2.resource.Observation observation) {
		html = observation.getText().getDivAsString();
		comment = observation.getText().getDivAsString();
		specimen = observation.getSpecimen().getDisplayElement().toString();
		status = observation.getStatus();
		interpretation = observation.getInterpretation().getText();
		encounter = observation.getEncounter().getDisplayElement().toString();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSpecimen() {
		return specimen;
	}

	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}

	public String getEncounter() {
		return encounter;
	}

	public void setEncounter(String encounter) {
		this.encounter = encounter;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
