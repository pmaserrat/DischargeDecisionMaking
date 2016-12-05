package fhirwhenready.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import fhirwhenready.fhir.apiimpl.FhirImpl;

public class TestingServlet extends HttpServlet{
	private static String serverBase = "https://fhir-open.sandboxcerner.com/may2015/d075cf8b-3261-481d-97e5-ba6c48d3b41f";
	
	public TestingServlet() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
    	FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");
    	if (fhir == null) {
 	       fhir = new FhirImpl();
 	    }

		request.getSession().setAttribute("fhir", fhir);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");
    	if (fhir == null) {
 	       fhir = new FhirImpl();
 	    }
    	 
        FhirContext ctx = FhirContext.forDstu2();
		IGenericClient client = ctx.newRestfulGenericClient(serverBase);
        fhir.setClient(client);

        fhir.getData();

		request.getSession().setAttribute("fhir", fhir);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
}
