package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import ca.uhn.fhir.rest.gclient.IRead;

public class PatientDAO {
	 
	
	public static Patient findByName(IGenericClient client,String lastName){
	
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Patient.class)
		      .where(Patient.NAME.matches().value(lastName))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();
	
		Patient patient = (Patient)results.getEntryFirstRep().getResource();
		return patient;
	}
	public static List<fhirwhenready.model.Patient> listPatients(IGenericClient client){
		
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Patient.class)
		      .where((Patient.NAME.matches().value("smith")))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();
		
		ArrayList<fhirwhenready.model.Patient> patients = new ArrayList<fhirwhenready.model.Patient>();
		for(Entry entry: results.getEntry()){
			Patient patient = (Patient)entry.getResource();
			patients.add(new fhirwhenready.model.Patient(client,patient));
		}
		
		
		return patients;
	}
	public static Patient findByName(IGenericClient client,String lastName, String firstName){
	
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Patient.class)
		      .where((Patient.NAME.matches().value(lastName)))
//		      .and(Patient.GIVEN.matches().value(firstName))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();
		
		for(Entry entry: results.getEntry()){
			Patient patient = (Patient)entry.getResource();
			System.out.println(patient.getNameFirstRep().getNameAsSingleString());
		}
		
		Patient patient = (Patient)results.getEntryFirstRep().getResource();
		return patient;
	}

	public static Patient findByID(IGenericClient client,String id){
	 
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Patient.class)
		      .where(Patient.RES_ID.matches().value(id))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();
		Patient patient = (Patient)results.getEntryFirstRep().getResource();
		return patient;
	}
}
