package fhirwhenready.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fhirwhenready.fhir.apiimpl.FhirImpl;

@WebServlet("patient")
public class PatientServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String patientID = request.getParameter("selectPatientID");
        FhirImpl fhir = (FhirImpl) request.getSession().getAttribute("fhir");

        if (fhir == null) {
        	fhir = new FhirImpl();
        	request.getSession().setAttribute("fhir", fhir);
        } else {
            if(patientID!=null){
            	fhir.setSelectedPatientByID(patientID);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        
	}

}
