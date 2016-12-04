package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.rest.client.IGenericClient;

public class ObservationDAO {
	public static List<fhirwhenready.model.Observation> findByPatientID(IGenericClient client, String id) {

		// Perform a search
		Bundle results = client.search().forResource(Observation.class).where(Observation.PATIENT.hasId(id))
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

		ArrayList<fhirwhenready.model.Observation> observations = new ArrayList<>();
		for (Entry entry : results.getEntry()) {
			observations.add(new fhirwhenready.model.Observation((Observation) entry.getResource()));
		}
		return observations;
	}

}
