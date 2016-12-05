<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="fhir" class="fhirwhenready.fhir.apiimpl.FhirImpl" scope="session"/>

<html>
<head>
	<title>Discharge Decision Making</title>
	<link rel="stylesheet" href="global.css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"/></script>
<style>
body {
	
	background-repeat: no-repeat;
	background-size: cover;
	background-color:#3fb0ac;
}
.info{
	color:white;
	font-weight:bold;
	font-size:20px;
}
.col-centered{
    float: none!important;
    margin: 0 auto;
}

.container{
	padding-top:30px;
}

.text-center{
	text-align:center;
}

.formPanel{
	margin-top:40px;
	padding:20px;
	background-color: #dddfd4;
	box-shadow
	-webkit-box-shadow: 6px 5px 6px 0px rgba(0,0,0,0.75);
	-moz-box-shadow: 6px 5px 6px 0px rgba(0,0,0,0.75);
	box-shadow: 6px 5px 6px 0px rgba(0,0,0,0.75);
	border-radius:5px;
}

.appHeader{
	font-size: 40px;
	font-weight: bold;
	color:white;
}

.patientSelect{
	font-size:20px;
}

.patientInfo{
	font-size:30px;
}

#selectpatientform{
	margin-bottom:0px;
}

</style>
</head>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-centered text-center">
				<p class="appHeader">Hospital Discharge Decision Making</p>
				<p class="info">Team: FHIR When Ready</p>
				<p class="info">Reece Karge, Joshua Kaelin, Paul Maserrat</p>
		</div>
	</div>

	<div class="row">
		<div class="col-xs-6 formPanel col-centered">
			<form id="selectpatientform"  method="POST" action="${pageContext.request.contextPath }/patient">
				<div class="row">
					<div class="col-xs-4">
						<p class="patientSelect">Select Patient:</p>
					</div>
					<div class="col-xs-8">
						<select name="selectPatientID" id="selectPatientID" size="1" onchange="this.form.submit()">
						    <c:forEach items="${fhir.patientList}" var="patient">
						        <option value="${patient.id}" ${patient.id == fhir.selectedPatient.id ? 'selected="selected"' : ''}>${patient.firstName} ${patient.lastName}</option>
						    </c:forEach>
						</select>
					</div>
				</div>
			</form>
		</div>
	</div>			
	<div class="row">
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Patient Information</p>
			<p><b>Name:</b> ${fhir.selectedPatient.firstName} ${fhir.selectedPatient.lastName}</p>
			<p><b>Gender:</b> ${fhir.selectedPatient.gender}</p>
			<p><b>Date of Birth:</b> ${fhir.selectedPatient.dob}</p>
			<p><b>Address:</b> ${fhir.selectedPatient.address}</p>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Encounters</p>
			<c:forEach items="${fhir.encounterList}" var="encounter">
				<p><b>Encounter:</b></p>
				<b>Date:</b> ${encounter.date}</br>
				<b>Location:</b> ${encounter.location}</br>
				<b>Reason:</b> ${encounter.reason}</br></br>
			</c:forEach>
		</div>
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Procedures</p>
			<c:forEach items="${fhir.procedureList}" var="procedure">
				${procedure.html}</br>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Observations</p>
			<c:forEach items="${fhir.observationList}" var="observation">
				${observation.html}</br>
			</c:forEach>
		</div>
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Conditions</p>
			<c:forEach items="${fhir.conditionList}" var="condition">
				${condition.html}</br>
			</c:forEach>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Care Plan</p>
			<c:forEach items="${fhir.carePlanList}" var="carePlan">
				 ${carePlan.html}</br>
			</c:forEach>
		</div>
		<div class="col-xs-6 formPanel col-centered">
			<p class="patientInfo">Medication Administration</p>
			<c:forEach items="${fhir.medicationAdministration}" var="adminsitration">
				${adminsitration.html}</br>
			</c:forEach>
		</div>
	</div>
</div>
</html>