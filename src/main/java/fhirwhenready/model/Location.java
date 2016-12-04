/**
 * 
 */
package fhirwhenready.model;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class Location {

	public String address;
	public String description;
	public String name;
	public String type;
	public String telecom;

	public Location(ca.uhn.fhir.model.dstu2.resource.Location location) {
		location.getAddress().getText();
		location.getDescription();
		location.getName();
		location.getPhysicalType().getText();
		location.getTelecomFirstRep();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

}
