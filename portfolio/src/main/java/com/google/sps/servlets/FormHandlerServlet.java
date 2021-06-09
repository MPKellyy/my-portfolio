package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Getting values entered in the form.
    String textValue = "";

    boolean jobOpportunity = Boolean.parseBoolean(getParameter(request, "Job", "false"));
    boolean internOpportunity = Boolean.parseBoolean(getParameter(request, "Intern", "false"));
    boolean otherOpportunity = Boolean.parseBoolean(getParameter(request, "Other", "false"));

    if(jobOpportunity){
       textValue += "Job Opportunity: ";
    }
    else if(internOpportunity){
       textValue += "Internship Opportunity: ";
    }
    else if(otherOpportunity){
        textValue += "Other Opportunity: ";
    }
    else{
        textValue += "Not Specified: ";
    }

    textValue += request.getParameter("text-input");

    // Print the value so you can see it in the server logs.
    System.out.println(textValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println(textValue);
  }

   /**
   * @return the request parameter, or the default value if the parameter
   *         was not specified by the client
   */
  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
