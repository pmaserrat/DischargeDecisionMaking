package fhirwhenready.model;

import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.rest.client.IGenericClient;
import fhirwhenready.fhir.api.dao.EncounterDAO;

public class Patient {
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
	private String gender;
	public List<fhirwhenready.model.Encounter> encounterList = null;
	private String id;
	public Patient(IGenericClient client,ca.uhn.fhir.model.dstu2.resource.Patient patient) {
		firstName=patient.getNameFirstRep().getGivenAsSingleString();
		lastName= patient.getNameFirstRep().getFamilyAsSingleString();
		if( patient.getAddressFirstRep()!=null){
			AddressDt addressdt= patient.getAddressFirstRep();
			if(addressdt.getLineFirstRep()!=null && !addressdt.getLineFirstRep().equals("null") && addressdt.getCity()!=null && !addressdt.getCity().equals("null"))
				address = addressdt.getLineFirstRep() +" "+addressdt.getCity()+" "+addressdt.getState()+" "+addressdt.getPostalCode();
		}
		if(patient.getBirthDate() !=null)
			dob = patient.getBirthDate().toString();
		gender =patient.getGender();
		id = patient.getId().getIdPart()+"";
		
	    encounterList =  EncounterDAO.findByPatientID(client,getId());
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
	
	public List<fhirwhenready.model.Encounter> getEncounterList() {
		return encounterList;
	}


	public void setEncounterList(List<fhirwhenready.model.Encounter> encounterList) {
		this.encounterList = encounterList;
	}
}
