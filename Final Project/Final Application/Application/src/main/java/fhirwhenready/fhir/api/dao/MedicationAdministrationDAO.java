package fhirwhenready.fhir.api.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MedicationAdministration;
import ca.uhn.fhir.rest.client.IGenericClient;

public class MedicationAdministrationDAO {

	public static List<fhirwhenready.model.MedicationAdministration> findByPatientID(IGenericClient client, String id) {

		ArrayList<fhirwhenready.model.MedicationAdministration> medicationAdministration = new ArrayList<>();
		try{
		// Perform a search
		Bundle results = client.search().forResource(MedicationAdministration.class)
				.where(MedicationAdministration.PATIENT.hasId(id))
				.returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class).execute();

		for (Entry entry : results.getEntry()) {
			medicationAdministration.add(
					new fhirwhenready.model.MedicationAdministration((MedicationAdministration) entry.getResource()));
		}
		}catch(Exception e){
			System.out.print(e);
		}
		return medicationAdministration;
	}

}
