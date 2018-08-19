package controller.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class SessionRequestContent {
    private HashMap<String, Object> requestAttributes;
    private Map<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;
    // конструкторы
// метод извлечения информации из запроса
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
    // метод добавления в запрос данных для передачи в jsp
    public void insertAttributes(HttpServletRequest request) {

    }
// some methods
}
