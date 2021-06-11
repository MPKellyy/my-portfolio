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

    //Checking which radio button is selected and updating textValue accordingly
    switch(request.getParameter("specifier").charAt(0)){
        case '1':
            textValue += "Job Opportunity: ";
            break;
        case '2':
            textValue += "Internship Opportunity: ";
            break;
        case '3':
            textValue += "Other Opportunity: ";
            break;
    }

    textValue += request.getParameter("text-input");

    // Print the value so you can see it in the server logs.
    System.out.println(textValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println(textValue);
  }
}
