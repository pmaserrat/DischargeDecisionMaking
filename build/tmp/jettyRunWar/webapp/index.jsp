<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="fhir" class="fhirwhenready.fhir.apiimpl.FhirImpl" scope="session"/>

<html>
<head>
	<title>Discharge Decision Making</title>
	<link rel="stylesheet" href="global.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/></script>

</head>
<div class="container">
	<div class="row">
		<div class="col-xs-6">
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
		</div>
	</div>
</div>
</html>