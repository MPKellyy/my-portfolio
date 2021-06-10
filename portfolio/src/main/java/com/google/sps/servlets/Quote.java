package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /rand-message URL. */
public final class Quote {
    //attributes
    private String author;
    private String quote;

    /**
     * Constructor for Quote class
     * @param author author of quote
     * @param quote the quote itself
     */
    public Quote(String author, String quote){
        this.author = author;
        this.quote = quote;
    }
}
