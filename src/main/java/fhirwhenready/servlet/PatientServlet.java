package fhirwhenready.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import fhirwhenready.fhir.apiimpl.FhirImpl;

<<<<<<< HEAD
public class PatientServlet extends HttpServlet{
	                   
	String ehrAuthURL="https://authorization.sandboxcerner.com/realms/d075cf8b-3261-481d-97e5-ba6c48d3b41f/protocols/smart/authorize";
	
=======
@WebServlet("patient")
public class PatientServlet extends HttpServlet {

>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
        String patientID = request.getParameter("selectPatientID");
        FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");

        if (fhir == null) {
        	fhir = new FhirImpl();
        } else {
            if(patientID!=null){
            	fhir.setSelectedPatientByID(patientID);
            }else{
            	
            }
        }
   
    	request.getSession().setAttribute("fhir", fhir);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
	}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");
    	
        String code = request.getParameter("code");
    	HttpClient httpclient = HttpClients.createDefault();
    	HttpPost httppost = new HttpPost(fhir.getEhrTokenURL());

    	// Request parameters and other properties.
    	List<NameValuePair> params = new ArrayList<NameValuePair>(2);
    	                                                 
    	params.add(new BasicNameValuePair("grant_type", "authorization_code"));
    	params.add(new BasicNameValuePair("code", code));
    	params.add(new BasicNameValuePair("client_id", "f6aad4f8-6bc1-40f3-83a6-5fcc9890cef0"));
//    	params.add(new BasicNameValuePair("redirect_uri ", "http://sample-env-2.daeijvm4s6.us-east-1.elasticbeanstalk.com/patient"));
    	httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    	//Execute and get the response.
    	HttpResponse httpResponse = httpclient.execute(httppost);
    	HttpEntity entity = httpResponse.getEntity();
    	String result="";
    	if (entity != null) {
    		 BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
   	         String line="testing";
   	         try{
   	        	 while ((line = rd.readLine()) != null) {
   	        		 result = result+ line;
   	        	 }
   	         }finally{
   	        	 rd.close();
   	         }
    	   
    	}
    	JSONObject myObject = new JSONObject(result);
        fhir.setUserMessage(myObject.getString("access_token"));
        fhir.setToken(myObject.getString("access_token"));
        fhir.getData();
    	request.getSession().setAttribute("fhir", fhir);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    
    
=======
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String patientID = request.getParameter("selectPatientID");
		FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");

		if (fhir == null) {
			fhir = new FhirImpl();
			request.getSession().setAttribute("fhir", fhir);
		} else {
			if (patientID != null) {
				fhir.setSelectedPatientByID(patientID);
				fhir.setPatientEncounters(patientID);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");
		if (fhir == null) {
			fhir = new FhirImpl();
			request.getSession().setAttribute("fhir", fhir);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
>>>>>>> branch 'master' of https://github.gatech.edu/gt-hit-fall2016/Discharge-Decision-Making---FHIR-When-Ready.git

}