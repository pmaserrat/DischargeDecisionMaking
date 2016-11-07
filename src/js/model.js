var model = new function() {
	
    this.init = function(f){
    	smart.patient.read().then(function(pt) {
    		model.ptAge= getAge(pt);
    		model.MaleGender= getMaleGender(pt);
    		model.WhiteRace;//--Not available--
    		model.BlackRace;//--Not available--
    		model.Ascites;//Condition
    		model.CHF;//Condition  http://snomed.info/sct 42343007
    		model.CANCER;//Condition http://snomed.info/sct 254837009 399068003 363358000
    		model.EmerAdmit;//encounter.hospitalization.admitSource=emd
    		model.RegAdmit;//encounter.hospitalization.admitSource!=emd
    		model.Procedure_i;//procedure
    		model.IVD;//Maybe? FHIR has codes for this but cant figure out where they are used.
    		model.Albumin;//Observation
    		model.AlkPhos;//Observation
    		model.ASTALT;//Observation
    		model.BUN;//Observation
    		model.Calcium;//Observation
    		model.Bicarb;//Observation
    		model.Cr;//Observation
    		model.HCT;//Observation
    		model.INR;//Observation
    		model.KPlus;//Observation
    		model.Sodium;//Observation
    		model.PLT;//Observation
    		model.PTT;//Observation
    		model.TBili;//Observation
    		model.WBC;//Observation
    		model.TransufeD;//Observation
    		model.DxImg;//Observation
    		model.KatzScore;//Observation
    		model.StoolPlus;//Observation
    		model.BMI;//Observation
    		model.HR;//Observation
    		model.O2Sat;//Observation
    		model.RR;//Observation
    		model.DBP;//Observation
    		model.SBP;//Observation
    		model.TEMP//Observation
    		model.PainScore;//-Observation - LOINC Code 72102-7 : Pain score [KOOS]
    		model.ComplexityRVUs;//Calculated
    		model.UnivHosp;//encounter.location.status = active
    		model.HighRisk;//ecounter and procedure
    		model.LOS;//encounter
    		model.LnLOS;//calculated 
    		model.NPO;//--Not available--
    		model.PreOptimize;//encounter and procedure

    		//set all variable to do with Condition resource
    		getConditions(f);
    	});
    }
    function getMedicationOrder(f){
    	model.medications=[];
    	smart.patient.api.fetchAllWithReferences({type: "MedicationOrder"},["MedicationOrder.medicationReference"]).then(function(results, refs) {
    		  results.forEach(function(prescription){
    		    if (prescription.medicationCodeableConcept) {
    		    	model.medications.push(prescription.medicationCodeableConcept.coding);
    		    } else if (prescription.medicationReference) {
    		        var med = refs(prescription, prescription.medicationReference);
    		        model.medications.push(med && med.code.coding || []);
    		    }
    		  });
    		  f(model);
    		});
    }
    function getConditions(f){
    	model.conditions=[];
    	model.DM=0;//default
		model.HTN=0;//default
    	smart.patient.api.fetchAllWithReferences({type: 'Condition'}).then(function(results) {
    		  results.forEach(function(prescription){
    			 if((prescription.code.coding[0].code == 46635009 && prescription.code.coding[0].system.localeCompare('http://snomed.info/sct')==0) || (prescription.code.coding[0].code == 44054006 && prescription.code.coding[0].system.localeCompare('http://snomed.info/sct')==0)){
    				 model.DM=1;
    			 }
    			 if(prescription.code.coding[0].code == 59621000 && prescription.code.coding[0].system.localeCompare('http://snomed.info/sct')==0){
    				 model.HTN=1;
    			 }
    			 // model.medications.push(prescription.code.coding);
    		  });
    		  f(model);
    		});
    }
    function getAge(pt){
    		var defaultVal = 18;
    		
        	if(pt.birthDate){
        		
        		var dob = new Date();
        		dob.setFullYear(Number(pt.birthDate.slice(0,4)));
        		dob.setDate(Number(pt.birthDate.slice(8,10)));
        		dob.setMonth(Number(pt.birthDate.slice(6,7)));
        		var today = new Date();
        		var age = today.getFullYear() - dob.getFullYear();
        	    var m = today.getMonth() - dob.getMonth();
        	    if (m < 0 || (m === 0 && today.getDate() < dob.getDate())) {
        	        age--;
        	    }
        	    return age;
        	}else{
        		return defaultVal;
        	}   	
    }
    function getMaleGender(pt){
    	var defaultVal = 1;
    	if(pt.gender){
    		if(pt.gender.localeCompare('female')==0){
    			return 0;
    		}else{
    			return 1;
    		}
    	}else{
    		return defaultVal;
    	}
    }
   
}
