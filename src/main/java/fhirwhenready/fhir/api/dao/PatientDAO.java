package fhirwhenready.fhir.api.dao;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;

public class PatientDAO {
	private static String serverBase = "https://fhir-open.sandboxcernerpowerchart.com/dstu2/d075cf8b-3261-481d-97e5-ba6c48d3b41f";
	 
	
	public static Patient findByName(String lastName){
		FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		 
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
	public static Patient findByName(String lastName, String firstName){
		FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		 
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

	public static Patient findByID(String id){
		FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		 
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
