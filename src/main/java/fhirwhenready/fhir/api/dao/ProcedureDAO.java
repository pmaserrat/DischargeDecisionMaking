package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Procedure;
import ca.uhn.fhir.rest.client.IGenericClient;

public class ProcedureDAO {

	public static List<fhirwhenready.model.Procedure> findByPatientID(IGenericClient client, String id) {
		ArrayList<fhirwhenready.model.Procedure> procedure = new ArrayList<>();
		try {
			// Perform a search
			Bundle results = client.search().forResource(Procedure.class).where(Procedure.PATIENT.hasId(id))
					.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

			for (Entry entry : results.getEntry()) {
				procedure.add(new fhirwhenready.model.Procedure((Procedure) entry.getResource()));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return procedure;
	}

}
