package fhirwhenready.fhir.apiimpl;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import fhirwhenready.fhir.api.dao.EncounterDAO;
import fhirwhenready.fhir.api.dao.PatientDAO;

public class FhirImpl {
	public List<fhirwhenready.model.Patient> patientList = null;
	public fhirwhenready.model.Patient selectedPatient = null;
	public List<fhirwhenready.model.Encounter> encounterList = null;

	public FhirImpl() {
		selectedPatient = new fhirwhenready.model.Patient(PatientDAO.findByName("Shannon smith"));
		patientList = PatientDAO.listPatients();
	}

	public static void main(String[] args) {

		Patient patient = PatientDAO.findByName("Foster");
		// Patient patient = PatientDAO.findByID("1078075");

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
}
