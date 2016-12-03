package fhirwhenready.fhir.apiimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.client.IRestfulClientFactory;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import fhirwhenready.fhir.api.dao.EncounterDAO;
import fhirwhenready.fhir.api.dao.PatientDAO;
import fhirwhenready.fhir.api.dao.PractitionerDAO;


public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList=null;
	public fhirwhenready.model.Patient selectedPatient = null;
	public String ehrTokenURL=null;
	public String ehrAuthURL=null;
	public IGenericClient client=null;
	public String ehrBaseURL="";
	public String launch="";
	public String token="";
	public String userMessage=null;
	public FhirImpl(){
	public List<fhirwhenready.model.Encounter> encounterList = null;

	public FhirImpl() {
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName("Shannon smith"));
		patientList = PatientDAO.listPatients();
	}

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
	public void setSelectedPatientByID(String id){
		for(fhirwhenready.model.Patient patient: patientList){
			if(patient.getId().equals(id)){
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
