package controller.Utils;

import model.entity.RoleEnum;

public class SecurityUtils {

    public boolean isSecurityPage(String urlPattern) {
        for (RoleEnum role : RoleEnum.values()) {
            if (urlPattern.contains(role.getValue())){
                return true;
            }
        }
        return false;
    }

    public boolean hasPermission(String urlPattern, String role) {
        return urlPattern.contains(role);
    }
}
