package controller.servlet;

import controller.command.Command;
import controller.command.CommandFactory;
import model.resource.manager.PagePathManager;
import model.resource.manager.ResourceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommandFromRequest(req);
        String page = command.execute(req);

        if (page != null) {
            if (page.contains("redirect:")) {
                page = page.replaceFirst("redirect:","");
                System.out.println(page);
                resp.sendRedirect(page);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
                dispatcher.forward(req, resp);
            }
        }else {
            ResourceManager manager = new PagePathManager();
            page = manager.getProperty("path.page.index");
//            request.getSession().setAttribute("nullPage",
//                    MessageManager.getProperty("message.nullpage"));
            resp.sendRedirect(req.getContextPath() + page);
        }
    }
}
