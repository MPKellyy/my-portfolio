package com.google.sps.servlets;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.Math;
import java.util.Random;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /rand-message URL. */
@WebServlet("/rand-message")
public class MessageServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //Creating ArrayList of Quotes
    ArrayList<String> messageList = new ArrayList<String>();
    String message1 = "\"The way to get started is to quit talking and begin doing.\"\n\n-Walt Disney";
    String message2 = "\"Tell me and I forget. Teach me and I remember. Involve me and I learn.\"\n\n-Benjamin Franklin";
    String message3 = "\"The future belongs to those who believe in the beauty of their dreams.\"\n\n-Eleanor Roosevelt";
    
    messageList.add(message1);
    messageList.add(message2);
    messageList.add(message3);

    //Creating JSON data and returning it as a response
    String jsonList = convertToJsonUsingGson(messageList);

    response.setContentType("application/json;");
    response.getWriter().println(jsonList);
  }

   /**
   * Converts a ArrayList<String> instance into a JSON string using the Gson library
   */
  private String convertToJsonUsingGson(ArrayList<String> inputMsgList) {
    Gson gson = new Gson();
    String json = gson.toJson(inputMsgList);
    return json;
  }
}
