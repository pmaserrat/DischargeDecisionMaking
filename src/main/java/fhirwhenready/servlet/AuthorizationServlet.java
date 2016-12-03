package fhirwhenready.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fhirwhenready.fhir.apiimpl.FhirImpl;

public class AuthorizationServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Override
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		String ehrBaseURL = request.getParameter("iss");
		String json =  getJsonFromURL(ehrBaseURL);
		JSONObject jsonObject = new JSONObject(json);
		String launch =  request.getParameter("launch");
		JSONArray securityURLs = jsonObject.getJSONArray("rest").getJSONObject(0).getJSONObject("security").getJSONArray("extension").getJSONObject(0).getJSONArray("extension");
		String uri="";
		String tokenUri="";
		for(int i=0; i<securityURLs.length();i++){
			JSONObject obj = securityURLs.getJSONObject(i);
			if(obj.getString("url").equals("authorize")){
				uri=obj.getString("valueUri");
			}
			if(obj.getString("url").equals("token")){
				tokenUri=obj.getString("valueUri");
			}
		}
		
		String ehrAuthURL=uri.replace("\\/", "/");
		String ehrTokenURL=tokenUri.replace("\\/", "/");
		FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");
		if (fhir == null) {
	       fhir = new FhirImpl();
	    }
		fhir.setEhrAuthURL(ehrAuthURL);
		fhir.setEhrTokenURL(ehrTokenURL);
		fhir.setLaunch(launch);
		fhir.setEhrBaseURL(ehrBaseURL);
		request.getSession().setAttribute("fhir", fhir);

//	      String url = ehrAuthURL+"?aud="+ehrBaseURL+"&launch="+launch+"&response_type=code&client_id=f6aad4f8-6bc1-40f3-83a6-5fcc9890cef0&scope=online_access&redirect_uri=http://sample-env-2.daeijvm4s6.us-east-1.elasticbeanstalk.com/patient";
	      String url = ehrAuthURL+"?aud="+ehrBaseURL+"&launch="+launch+"&response_type=code&client_id=f6aad4f8-6bc1-40f3-83a6-5fcc9890cef0&scope=launch,online_access,user/Patient.read";

	   
	      response.sendRedirect(url);
    }
	public String getJsonFromURL(String baseURL) throws ClientProtocolException, IOException{
		
		  StringBuilder result = new StringBuilder();
	      URL url = new URL(baseURL+"/metadata");
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      conn.setRequestProperty("Accept", "application/json");
	      try{
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      }finally{
	    	  conn.disconnect();
	      }
	      return result.toString();
	}

}
