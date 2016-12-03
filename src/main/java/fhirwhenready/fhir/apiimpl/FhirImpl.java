package fhirwhenready.fhir.apiimpl;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Patient;
<<<<<<< HEAD
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.client.IRestfulClientFactory;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
=======
>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git
import fhirwhenready.fhir.api.dao.EncounterDAO;
import fhirwhenready.fhir.api.dao.PatientDAO;

public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList = null;
	public fhirwhenready.model.Patient selectedPatient = null;
<<<<<<< HEAD
	public String ehrTokenURL=null;
	public String ehrAuthURL=null;
	public IGenericClient client=null;
	public String ehrBaseURL="";
	public String launch="";
	public String token="";
	public String userMessage=null;
	public FhirImpl(){
=======
>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git
	public List<fhirwhenready.model.Encounter> encounterList = null;

	public FhirImpl() {
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName("Shannon smith"));
		patientList = PatientDAO.listPatients();
	}
<<<<<<< HEAD
=======

	public static void main(String[] args) {

		Patient patient = PatientDAO.findByName("Foster");
		// Patient patient = PatientDAO.findByID("1078075");
>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git

<<<<<<< HEAD
=======
		System.out.println("----------Patient-------");
		System.out.println("ID:" + patient.getId());
		System.out.println("Name: " + patient.getNameFirstRep().getNameAsSingleString());
		System.out.println("Gender: " + patient.getGender());
		AddressDt address = patient.getAddressFirstRep();
		System.out.println("Address: " + address.getLineFirstRep() + " " + address.getCity() + " " + address.getState()
				+ " " + address.getPostalCode());
		System.out.println("DOB: " + patient.getBirthDate());

		System.out.println();
		System.out.println("----------Encounters-------");
		ArrayList<Encounter> encounters = (ArrayList<Encounter>) EncounterDAO
				.findByPatientID(patient.getId().getIdPart() + "");

		// *************
		// Here im taking the encounters returned and setting the needed values
		// to the fhirwhenready.model.Encounter
		// Having trouble setting it to be used in the jsp.

		List<fhirwhenready.model.Encounter> encountersList = null;
		for (Encounter encounter : encounters) {
			System.out.println("Location:" + encounter.getLocationFirstRep().getLocation());
			System.out.println("Reason for visit: " + encounter.getReasonFirstRep().getText());
			fhirwhenready.model.Encounter patientEncounter = new fhirwhenready.model.Encounter(encounter);
			encountersList.add(patientEncounter);
		}
		// setEncounters(encountersList);
	}

>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git
	public List<fhirwhenready.model.Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<fhirwhenready.model.Patient> patientList) {
		this.patientList = patientList;
	}
	public void getData(){
	
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName(token,ehrBaseURL,"Shannon smith"));	
		patientList = PatientDAO.listPatients(token,ehrBaseURL);
		
	}
	public fhirwhenready.model.Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(fhirwhenready.model.Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public List<fhirwhenready.model.Encounter> getEncounters() {
		return encounterList;
	}

	public void setEncounters(List<fhirwhenready.model.Encounter> encounters) {
		this.encounterList = encounters;
	}

	public void setPatientEncounters(String id) {

		// setEncounters()
	}

	public void setSelectedPatientByID(String id) {
		for (fhirwhenready.model.Patient patient : patientList) {
			if (patient.getId().equals(id)) {
				setSelectedPatient(patient);
			}
		}
	}
	public List<fhirwhenready.model.Encounter> getEncounters() {
		return encounterList;
	}

	public void setEncounters(List<fhirwhenready.model.Encounter> encounters) {
		this.encounterList = encounters;
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
	
}
