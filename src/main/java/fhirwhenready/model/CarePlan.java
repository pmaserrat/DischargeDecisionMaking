/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class CarePlan {

	public String details;
	public String author;
	public String status;
	public String participantMember;
	public String participantRole;
	public String category;
	public String context;

	public CarePlan(ca.uhn.fhir.model.dstu2.resource.CarePlan carePlan) {
		carePlan.getActivityFirstRep().getDetail();
		carePlan.getAuthor().get(0).getDisplayElement().getValue();
		carePlan.getStatus();
		carePlan.getParticipantFirstRep().getMember().getDisplayElement().getValue();
		carePlan.getParticipantFirstRep().getRole().getText();
		carePlan.getCategory().get(0).getText();
		carePlan.getContext().getDisplayElement().getValue();
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParticipantMember() {
		return participantMember;
	}

	public void setParticipantMember(String participantMember) {
		this.participantMember = participantMember;
	}

	public String getParticipantRole() {
		return participantRole;
	}

	public void setParticipantRole(String participantRole) {
		this.participantRole = participantRole;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
