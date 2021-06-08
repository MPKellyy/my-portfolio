package com.google.sps.servlets;

import java.util.Calendar;
import java.lang.Math;
import java.util.Random;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /lucky URL. */
@WebServlet("/lucky")
public class LuckyServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println(Math.abs(new Random().nextInt()));
  }
}
