package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Condition;
import ca.uhn.fhir.rest.client.IGenericClient;

public class ConditionDAO {

	public static List<fhirwhenready.model.Condition> findByPatientID(IGenericClient client, String id) {
		ArrayList<fhirwhenready.model.Condition> condition = new ArrayList<>();
		try {
			// Perform a search
			Bundle results = client.search().forResource(Condition.class).where(Condition.PATIENT.hasId(id))
					.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

			for (Entry entry : results.getEntry()) {
				condition.add(new fhirwhenready.model.Condition((Condition) entry.getResource()));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return condition;
	}
}
