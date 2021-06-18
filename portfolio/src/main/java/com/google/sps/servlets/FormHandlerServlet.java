package com.google.sps.servlets;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import java.util.Date;
import java.lang.String;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * Responsible for collecting and storing contact-me.html form data
 */
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Getting values entered in the form.
    String contactInfo = Jsoup.clean(request.getParameter("contact-input"), Whitelist.none());
    String message = Jsoup.clean(request.getParameter("message-input"), Whitelist.none());
    String positionTitle = Jsoup.clean(request.getParameter("position-input"), Whitelist.none());
    String opportunityType = "";
    boolean showcasePermission = true;

    //Checking which radio button is for opportunity type selected and updating textValue accordingly
    switch(request.getParameter("specifier").charAt(0)){
        case '1':
            opportunityType += "Job Opportunity";
            break;
        case '2':
            opportunityType += "Internship Opportunity";
            break;
        case '3':
            opportunityType += "Other Opportunity";
            break;
    }

    //Checking if employer does no allow opportunity to be displayed
    if(request.getParameter("permission").equals("2")){
        showcasePermission = false;
    }

    // try{
    //     //Calculating Sentiment Score of Form
    //     String form = contactInfo + ". " + positionTitle + ". " + message + ".";
    //     Document doc = Document.newBuilder().setContent(form).setType(Document.Type.PLAIN_TEXT).build();
    //     LanguageServiceClient languageService = LanguageServiceClient.create();
    //     Sentiment sentiment = languageService.analyzeSentiment(doc).getDocumentSentiment();
    //     float score = sentiment.getScore();
    //     languageService.close();

    //     //If sentiment score is below specified threshold, it will not be displayed (prevents spam/trolls)
    //     if(Float.compare(score, 0) < 0){
    //         showcasePermission = false;
    //     }
    // }
    // catch(Exception e){
    //     System.out.println("Sentiment check failed to execute.");
    // }

    //Saving form to database
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Employer");
    FullEntity employerEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("type", opportunityType)
            .set("contactInfo", contactInfo)
            .set("message", message)
            .set("positionTitle", positionTitle)
            .set("showcasePermission", showcasePermission)
            .set("date", new Date().toString())
            //TODO: Add an option to upload an image
            .build();
    datastore.put(employerEntity);


    response.sendRedirect("contact-me.html");

  }
}
