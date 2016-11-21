package fhirwhenready.model;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;

public class Patient {
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
	private String gender;
	private String id;
	public Patient(ca.uhn.fhir.model.dstu2.resource.Patient patient) {
		firstName=patient.getNameFirstRep().getGivenAsSingleString();
		lastName= patient.getNameFirstRep().getFamilyAsSingleString();
		AddressDt addressdt= patient.getAddressFirstRep();
		address = addressdt.getLineFirstRep() +" "+addressdt.getCity()+" "+addressdt.getState()+" "+addressdt.getPostalCode();
		if(patient.getBirthDate() !=null)
			dob = patient.getBirthDate().toString();
		gender =patient.getGender();
		id = patient.getId().getIdPart()+"";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
