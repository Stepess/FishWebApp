package controller.Utils;

import model.entity.RoleEnum;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {

    public boolean isSecurityPage(HttpServletRequest request) {

        String urlPattern =  request.getRequestURI();

        for (RoleEnum role : RoleEnum.values()) {
            if (urlPattern.contains(role.toString().toLowerCase())){
                return true;
            }
        }

        return false;
    }

    // Проверить имеет ли данный 'request' подходящую роль?
    public boolean hasPermission(HttpServletRequest request) {
        String urlPattern = request.getRequestURI();

        String userRole = request.getSession().getAttribute("role").toString().toLowerCase();
        if (urlPattern.contains(userRole)){
            return true;
        }
        return false;
    }
}
