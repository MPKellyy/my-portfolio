package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing opportunities. */
@WebServlet("/showcase-opportunity")
public class ShowcaseHandler extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Employer").build();
    QueryResults<Entity> results = datastore.run(query);

    ArrayList<Employer> willingEmployers = new ArrayList<Employer>();

    while (results.hasNext()) {
      Entity entity = results.next();

      if(entity.getBoolean("showcasePermission")){
          Employer anEmployer = new Employer(entity.getString("contactInfo"), entity.getString("message"), entity.getString("positionTitle"), entity.getString("type"), entity.getBoolean("showcasePermission"), entity.getString("date"));
          willingEmployers.add(anEmployer);
      }

    }

    //Creating JSON data and returning it as a response
    String jsonList = convertToJsonUsingGson(willingEmployers);

    response.setContentType("application/json;");
    response.getWriter().println(jsonList);
  }

   /**
   * Converts a ArrayList<Employer> instance into a JSON string using the Gson library
   */
  private String convertToJsonUsingGson(ArrayList<Employer> inputEmployerList) {
    Gson gson = new Gson();
    String json = gson.toJson(inputEmployerList);
    return json;
  }
}