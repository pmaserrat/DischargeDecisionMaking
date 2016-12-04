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
import fhirwhenready.fhir.api.dao.CarePlanDAO;
import fhirwhenready.fhir.api.dao.ConditionDAO;
import fhirwhenready.fhir.api.dao.MedicationAdministrationDAO;
import fhirwhenready.fhir.api.dao.ObservationDAO;
import fhirwhenready.fhir.api.dao.ProcedureDAO;

import fhirwhenready.fhir.api.dao.PatientDAO;

public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList = null;
	public fhirwhenready.model.Patient selectedPatient = null;
	
	public List<fhirwhenready.model.CarePlan> carePlanList = null;
	public List<fhirwhenready.model.Condition> conditionList = null;
	public List<fhirwhenready.model.MedicationAdministration> medicationAdministration = null;
	public List<fhirwhenready.model.Observation> observationList = null;
	public List<fhirwhenready.model.Procedure> procedureList = null;

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
		selectedPatient = new fhirwhenready.model.Patient(client,PatientDAO.findByName(client,"Shannon smith"));	
		patientList = PatientDAO.listPatients(client);
		carePlanList = CarePlanDAO.findByPatientID(client, PatientDAO.findByName(client,"Shannon smith").toString());
		conditionList = ConditionDAO.findByPatientID(client, PatientDAO.findByName(client,"Shannon smith").toString());
		medicationAdministration = MedicationAdministrationDAO.findByPatientID(client,  PatientDAO.findByName(client,"Shannon smith").toString());
		observationList = ObservationDAO.findByPatientID(client, PatientDAO.findByName(client,"Shannon smith").toString());
		procedureList = ProcedureDAO.findByPatientID(client, PatientDAO.findByName(client,"Shannon smith").toString()); 
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


	public List<fhirwhenready.model.CarePlan> getCarePlanList() {
		return carePlanList;
	}


	public void setCarePlanList(List<fhirwhenready.model.CarePlan> carePlanList) {
		this.carePlanList = carePlanList;
	}


	public List<fhirwhenready.model.Condition> getConditionList() {
		return conditionList;
	}


	public void setConditionList(List<fhirwhenready.model.Condition> conditionList) {
		this.conditionList = conditionList;
	}


	public List<fhirwhenready.model.MedicationAdministration> getMedicationAdministration() {
		return medicationAdministration;
	}


	public void setMedicationAdministration(List<fhirwhenready.model.MedicationAdministration> medicationAdministration) {
		this.medicationAdministration = medicationAdministration;
	}


	public List<fhirwhenready.model.Observation> getObservationList() {
		return observationList;
	}


	public void setObservationList(List<fhirwhenready.model.Observation> observationList) {
		this.observationList = observationList;
	}


	public List<fhirwhenready.model.Procedure> getProcedureList() {
		return procedureList;
	}


	public void setProcedureList(List<fhirwhenready.model.Procedure> procedureList) {
		this.procedureList = procedureList;
	}


	
}
