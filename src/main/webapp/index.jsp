<jsp:useBean id="fhir" class="fhirwhenready.fhir.apiimpl.FhirImpl"/>
<html>
<h1>Patient Information</h1>
<p>Name: ${fhir.selectedPatient.firstName} ${fhir.selectedPatient.lastName}</p>
<p>Gender: ${fhir.selectedPatient.gender}</p>
<p>Date of Birth: ${fhir.selectedPatient.dob}</p>
<p>Address: ${fhir.selectedPatient.address}</p>
</html>