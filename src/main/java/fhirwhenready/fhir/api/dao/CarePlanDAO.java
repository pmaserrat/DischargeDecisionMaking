/**
 * 
 */
package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.CarePlan;
import ca.uhn.fhir.rest.client.IGenericClient;

/**
 * @author Pmaserrat
 * @date Dec 3, 2016
 */
public class CarePlanDAO {

	public static List<fhirwhenready.model.CarePlan> findByPatientID(IGenericClient client, String id) {
		ArrayList<fhirwhenready.model.CarePlan> carePlan = new ArrayList<>();
		try {
			// Perform a search
			Bundle results = client.search().forResource(CarePlan.class).where(CarePlan.PATIENT.hasId(id))
					.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

			for (Entry entry : results.getEntry()) {
				carePlan.add(new fhirwhenready.model.CarePlan((CarePlan) entry.getResource()));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return carePlan;
	}

}
