package fhirwhenready.fhir.api.dao;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.client.IGenericClient;

public class PractitionerDAO {
	private static String serverBase = "https://fhir-open.sandboxcernerpowerchart.com/dstu2/d075cf8b-3261-481d-97e5-ba6c48d3b41f";
	 
	public static Practitioner findByID(String id){
		FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
		 
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Practitioner.class)
		      .where(Practitioner.IDENTIFIER.exactly().identifier(id))
		      .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
		      .execute();
		Practitioner practitioner = (Practitioner)results.getEntryFirstRep().getResource();
		return practitioner;
	}
}

