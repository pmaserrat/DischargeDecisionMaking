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
	private static String serverBase = "https://fhir-open.sandboxcerner.com/may2015/d075cf8b-3261-481d-97e5-ba6c48d3b41f";
	 
	
	public static Patient findByName(String token,String ehrBaseURL,String lastName){
	 FhirContext ctx = FhirContext.forDstu2();
		
		System.out.println("--------Token: "+token+"-------------");
		BearerTokenAuthInterceptor authInterceptor = new BearerTokenAuthInterceptor(token);

		System.out.println("--------ehrBaseURL: "+ehrBaseURL+"-------------");
		
		IGenericClient client = ctx.newRestfulGenericClient(ehrBaseURL);

		client.registerInterceptor(authInterceptor);
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
	public static List<fhirwhenready.model.Patient> listPatients(String token,String ehrBaseURL ){
		 FhirContext ctx = FhirContext.forDstu2();
			
			System.out.println("--------Token: "+token+"-------------");
			BearerTokenAuthInterceptor authInterceptor = new BearerTokenAuthInterceptor(token);

			System.out.println("--------ehrBaseURL: "+ehrBaseURL+"-------------");
			
			IGenericClient client = ctx.newRestfulGenericClient(ehrBaseURL);
			client.registerInterceptor(authInterceptor);
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
			patients.add(new fhirwhenready.model.Patient(patient));
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
