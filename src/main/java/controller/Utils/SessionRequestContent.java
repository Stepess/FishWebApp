package controller.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes;
    private Map<String, String[]> requestParameters;
    private Map<String, Object> sessionAttributes;
    private boolean invalidateSession;

    private Map<String, Object> attributesToRequest;
    private Map<String, Object> attributesToSession;

    public SessionRequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
        attributesToRequest = new HashMap<>();
        attributesToSession = new HashMap<>();
        invalidateSession = false;
    }

    public void extractValues(HttpServletRequest request) {
        requestParameters = request.getParameterMap();
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String elementName = attributeNames.nextElement();
            requestAttributes.put(elementName, request.getAttribute(elementName));
        }
        HttpSession session = request.getSession();
        attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String elementName = attributeNames.nextElement();
            sessionAttributes.put(elementName, session.getAttribute(elementName));
        }

    }

    public void acceptChanges(HttpServletRequest request) {
        insertAttributes(request);
        invalidateSession(request);
    }

    public void insertAttributes(HttpServletRequest request) {
        for (String key: attributesToRequest.keySet()) {
            request.setAttribute(key, attributesToRequest.get(key));
        }
        HttpSession session = request.getSession();
        for (String key: attributesToSession.keySet()) {
            session.setAttribute(key, attributesToSession.get(key));
        }
    }

    public void invalidateSession(HttpServletRequest request) {
        if (invalidateSession) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
        }
        invalidateSession = false;
    }

    public void addAttributeToSetRequest(String key, Object attribute) {
        attributesToRequest.put(key, attribute);
    }

    public void addAttributeToSetSession(String key, Object attribute) {
        attributesToSession.put(key, attribute);
    }

    public Object getRequestAttribute(String key) {
        return requestAttributes.get(key);
    }

    public String getRequestParameter(String key) {
        return  requestParameters.get(key)[0];
    }

    public String[] getRequestParameters(String key) {
        return  requestParameters.get(key);
    }

    public Object getSessionAttribute(String key) {
        return sessionAttributes.get(key);
    }

    public void setInvalidateSession(boolean invalidateSession) {
        this.invalidateSession = invalidateSession;
    }



}
