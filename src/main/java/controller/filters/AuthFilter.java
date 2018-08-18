package controller.filters;

import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

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
        HttpSession session = request.getSession();
        ResourceManager manager = new PagePathManager();
        String path = request.getRequestURI();
        path = path.replaceAll("/*/app/", "");
        path = path.replaceAll("/.*", "");

        if (path != null && session.getAttribute("role")!=null && !path.equals(session.getAttribute("role").toString().toLowerCase()))
            response.sendRedirect(manager.getProperty("path.page.index"));

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
