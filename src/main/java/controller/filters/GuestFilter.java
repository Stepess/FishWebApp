package controller.filters;

import model.entity.RoleEnum;
import model.resource.manager.PagePathManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GuestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null) {
            session.setAttribute("role", RoleEnum.GUEST.getValue());
            RequestDispatcher dispatcher = request.getRequestDispatcher(new PagePathManager().getProperty("path.page.index"));
            dispatcher.forward(request, response);
            return;
        }
        System.out.println(session.getId());
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
