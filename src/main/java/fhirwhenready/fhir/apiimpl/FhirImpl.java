package fhirwhenready.fhir.apiimpl;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.client.IRestfulClientFactory;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import fhirwhenready.fhir.api.dao.EncounterDAO;
import fhirwhenready.fhir.api.dao.PatientDAO;

public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList = null;
	public fhirwhenready.model.Patient selectedPatient = null;
	public List<fhirwhenready.model.Encounter> encounterList = null;

	public String ehrTokenURL=null;
	public String ehrAuthURL=null;
	public IGenericClient client=null;
	public String ehrBaseURL="";
	public String launch="";
	public String token="";
	public String userMessage=null;

	public FhirImpl() {
		
	}


//	public static void main(String[] args) {
//
//		Patient patient = PatientDAO.findByName("Foster");
//		// Patient patient = PatientDAO.findByID("1078075");
//		System.out.println("----------Patient-------");
//		System.out.println("ID:" + patient.getId());
//		System.out.println("Name: " + patient.getNameFirstRep().getNameAsSingleString());
//		System.out.println("Gender: " + patient.getGender());
//		AddressDt address = patient.getAddressFirstRep();
//		System.out.println("Address: " + address.getLineFirstRep() + " " + address.getCity() + " " + address.getState()
//				+ " " + address.getPostalCode());
//		System.out.println("DOB: " + patient.getBirthDate());
//
//		System.out.println();
//		System.out.println("----------Encounters-------");
//		ArrayList<Encounter> encounters = (ArrayList<Encounter>) EncounterDAO
//				.findByPatientID(patient.getId().getIdPart() + "");
//
//		// *************
//		// Here im taking the encounters returned and setting the needed values
//		// to the fhirwhenready.model.Encounter
//		// Having trouble setting it to be used in the jsp.
//
//		List<fhirwhenready.model.Encounter> encountersList = null;
//		for (Encounter encounter : encounters) {
//			System.out.println("Location:" + encounter.getLocationFirstRep().getLocation());
//			System.out.println("Reason for visit: " + encounter.getReasonFirstRep().getText());
//			fhirwhenready.model.Encounter patientEncounter = new fhirwhenready.model.Encounter(encounter);
//			encountersList.add(patientEncounter);
//		}
//		// setEncounters(encountersList);
//	}

	public List<fhirwhenready.model.Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<fhirwhenready.model.Patient> patientList) {
		this.patientList = patientList;
	}
	public void getData(){
	
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName(client,"Shannon smith"));	
		patientList = PatientDAO.listPatients(client);
	    encounterList =  EncounterDAO.findByPatientID(client,selectedPatient.getId());
		
	}
	public fhirwhenready.model.Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(fhirwhenready.model.Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public void setSelectedPatientByID(String id) {
		for (fhirwhenready.model.Patient patient : patientList) {
			if (patient.getId().equals(id)) {
				setSelectedPatient(patient);
			}
		}
	}
	public void setPatientEncounters(String id) {

		// setEncounters()
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getEhrTokenURL() {
		return ehrTokenURL;
	}
	public void setEhrTokenURL(String ehrTokenURL) {
		this.ehrTokenURL = ehrTokenURL;
	}
	public String getEhrAuthURL() {
		return ehrAuthURL;
	}
	public void setEhrAuthURL(String ehrAuthURL) {
		this.ehrAuthURL = ehrAuthURL;
	}
	public String getEhrBaseURL() {
		return ehrBaseURL;
	}
	public void setEhrBaseURL(String ehrBaseURL) {
		this.ehrBaseURL = ehrBaseURL;
	}
	public String getLaunch() {
		return launch;
	}
	public void setLaunch(String launch) {
		this.launch = launch;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IGenericClient getClient() {
		return client;
	}
	public void setClient(IGenericClient client) {
		this.client=client;
	}


	public List<fhirwhenready.model.Encounter> getEncounterList() {
		return encounterList;
	}


	public void setEncounterList(List<fhirwhenready.model.Encounter> encounterList) {
		this.encounterList = encounterList;
	}
	
}
