<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="fhir" class="fhirwhenready.fhir.apiimpl.FhirImpl" scope="session"/>

<html>
<head>
</head>
<form id="selectpatientform"  method="POST" action="${pageContext.request.contextPath }/patient">
Select Patient:
<select name="selectPatientID" id="selectPatientID" size="1" onchange="this.form.submit()">
    <c:forEach items="${fhir.patientList}" var="patient">
        <option value="${patient.id}" ${patient.id == fhir.selectedPatient.id ? 'selected="selected"' : ''}>${patient.firstName} ${patient.lastName}</option>
    </c:forEach>
</select>
</form>
<h1>Patient Information</h1>
<p><b>Name:</b> ${fhir.selectedPatient.firstName} ${fhir.selectedPatient.lastName}</p>
<p><b>Gender:</b> ${fhir.selectedPatient.gender}</p>
<p><b>Date of Birth:</b> ${fhir.selectedPatient.dob}</p>
<p><b>Address:</b> ${fhir.selectedPatient.address}</p>
</html>