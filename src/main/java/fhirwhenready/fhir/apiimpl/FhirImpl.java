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
import fhirwhenready.fhir.api.dao.EncounterDAO;
import fhirwhenready.fhir.api.dao.PatientDAO;
import fhirwhenready.fhir.api.dao.PractitionerDAO;


public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList=null;
	public fhirwhenready.model.Patient selectedPatient = null;
	public FhirImpl(){
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName("Shannon smith"));	
		patientList = PatientDAO.listPatients();
	}
	public static void main(String[] args){
		
		Patient patient = PatientDAO.findByName("Foster");	
//		Patient patient = PatientDAO.findByID("1078075");

		System.out.println("----------Patient-------");
		System.out.println("ID:"+patient.getId());
		System.out.println("Name: "+patient.getNameFirstRep().getNameAsSingleString());
		System.out.println("Gender: "+patient.getGender());
		AddressDt address= patient.getAddressFirstRep();
		System.out.println("Address: "+address.getLineFirstRep() +" "+address.getCity()+" "+address.getState()+" "+address.getPostalCode());
		System.out.println("DOB: "+patient.getBirthDate());
		
		System.out.println();
		System.out.println("----------Encounters-------");
		ArrayList<Encounter> encounters = (ArrayList<Encounter>) EncounterDAO.findByPatientID(patient.getId().getIdPart()+"");
		for(Encounter encounter: encounters){
			System.out.println("Location:"+encounter.getLocationFirstRep().getLocation());
			System.out.println("Reason for visit: "+encounter.getReasonFirstRep().getText());
		}
		
	}
	public List<fhirwhenready.model.Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<fhirwhenready.model.Patient> patientList) {
		this.patientList = patientList;
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
}
