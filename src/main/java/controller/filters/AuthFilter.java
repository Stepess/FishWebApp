package controller.filters;

import controller.Utils.SecurityUtils;
import controller.exception.AccessDeniedException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SecurityUtils utils = new SecurityUtils();

        String servletPath = request.getServletPath();

        HttpSession session = request.getSession();
        String userRole = null;
        if (session.getAttribute("role") != null) {
            userRole = request.getSession().getAttribute("role").toString();
        }
        if (utils.isSecurityPage(request)){
            if (userRole == null) {
                System.out.println("hello from redirect sdfghjhwertyuuytrew");
                response.sendRedirect(request.getContextPath() + "/index.jsp");

            } else {
                System.out.println(userRole);
                boolean hasPermission = utils.hasPermission(request);
                System.out.println("hello after boolean haspermission");
                if (!hasPermission) {
                    System.out.println("hellor from if");
                    throw new AccessDeniedException();
                }
            }
            }


        /*if (userRole == null || userRole.isEmpty()) {
            request.getRequestDispatcher(new PagePathManager().getProperty("path.page.index"));
            //filterChain.doFilter(request, response);
            //return;
        } else {*/


            String path = request.getRequestURI();
//        path = path.replaceAll("/*/app/", "");
//        path = path.replaceAll("/.*", "");


            /*if (path != null && !path.contains(userRole.toLowerCase())) {
                throw new AccessDeniedException();
            }
        }*/
        /*if (path != null && session.getAttribute("role")!=null && !path.equals(session.getAttribute("role").toString().toLowerCase()))
            response.sendRedirect(manager.getProperty("path.page.index"));*/

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
