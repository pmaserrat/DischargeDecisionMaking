/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Nov 30, 2016
 */
public class Encounter {

	private String reason;
	private String location;
	private String date;

	public Encounter(ca.uhn.fhir.model.dstu2.resource.Encounter encounter) {
		reason = encounter.getReasonFirstRep().getTextElement().toString();
		location = encounter.getLocationFirstRep().getLocation().getDisplayElement().toString();
		date = encounter.getPeriod().getStartElement().getValueAsString();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
