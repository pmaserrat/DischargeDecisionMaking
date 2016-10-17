var model = new function() {
	
    this.init = function(f){
    	smart.patient.read().then(function(pt) {
    		this.ptAge= getAge(pt);
    		this.MaleGender= getMaleGender(pt);
    		this.WhiteRace;
    		this.BlackRace;
    		this.Ascites;
    		this.CHF;
    		this.DM;
    		this.CANCER;
    		this.HTN;
    		this.EmerAdmit;
    		this.RegAdmit;
    		this.Procedure_i;
    		this.IVD;
    		this.Albumin;
    		this.AlkPhos;
    		this.AST/ALT;
    		this.BUN;
    		this.Calcium;
    		this.Bicarb;
    		this.Cr;
    		this.HCT;
    		this.INR;
    		this.KPlus;
    		this.Sodium;
    		this.PLT;
    		this.PTT;
    		this.TBili;
    		this.WBC;
    		this.TransufeD;
    		this.DxImg;
    		this.KatzScore;
    		this.Stool+;
    		this.BMI;
    		this.HR;
    		this.O2Sat;
    		this.RR;
    		this.DBP;
    		this.SBP;
    		this.TEMP
    		this.PainScore;
    		this.Complexity(RVUs);
    		this.UnivHosp;
    		this.HighRisk;
    		this.LOS;
    		this.LnLOS;
    		this.NPO;
    		this.PreOptimize;
       
    		f(this);
    	});
    }
    function getAge(pt){
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
        		return null;
        	}   	
    }
    function getMaleGender(pt){
    	if(pt.gender){
    		if(pt.gender.localeCompare('female')==0){
    			return 0;
    		}else{
    			return 1;
    		}
    	}else{
    		return null;
    	}
    }
   
}
