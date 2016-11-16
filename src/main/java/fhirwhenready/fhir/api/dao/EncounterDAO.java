package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;

public class EncounterDAO {
	private static String serverBase = "https://fhir-open.sandboxcernerpowerchart.com/dstu2/d075cf8b-3261-481d-97e5-ba6c48d3b41f";
	
	public static List<Encounter> findByPatientID(String id){
		FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		 
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Encounter.class)
		      .where(Encounter.PATIENT.hasId(id))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();

		ArrayList<Encounter> encounters = new ArrayList<>();
		for(Entry entry: results.getEntry()){
			encounters.add((Encounter)entry.getResource());
			
		}
		return encounters;
	}
}
