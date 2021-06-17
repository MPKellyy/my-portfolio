package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Class that serves to represent an employer */
public final class Employer {
    //attributes
    private String contactInfo;
    private String message;
    private String positionTitle;
    private String opportunityType;
    private boolean showcasePermission;
    private String dateContacted;

    /**
     * Constructor for Employer class
     * @param contactInfo
     * @param message
     * @param positionTitle
     * @param opportunityType
     * @param showcasePermission
     */
    public Employer(String contactInfo, String message, String positionTitle, String opportunityType, boolean showcasePermission, String dateContacted){
        this.contactInfo = contactInfo;
        this.message = message;
        this.positionTitle = positionTitle;
        this.opportunityType = opportunityType;
        this.showcasePermission = showcasePermission;
        this.dateContacted = dateContacted;
    }
}
