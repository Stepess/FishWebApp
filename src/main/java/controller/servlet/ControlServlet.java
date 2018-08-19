package controller.servlet;

import controller.Utils.SessionRequestContent;
import controller.command.Command;
import controller.command.CommandFactory;

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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommandFromRequest(request);
        SessionRequestContent content = new SessionRequestContent();
        content.extractValues(request);
        String page = command.execute(content);
        content.acceptChanges(request);

        if (page.contains("redirect:")){
            response.sendRedirect(request.getContextPath() + page.replace("redirect:", ""));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }




























        /*String action = req.getRequestURI();
        action = action.replaceAll(".*//*app/", "");
        CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
        command = currentEnum.getCommand();

        String page = command.execute(req);

        if (page.contains("redirect:")) {
            page = page.replaceFirst("redirect:","");
            System.out.println("redirect page = " + page);
            resp.sendRedirect( page);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }*/


        /*if (page != null) {
            if (page.contains("redirect:")) {
                page = page.replaceFirst("redirect:","");
                System.out.println("redirect page = " + page);
                resp.sendRedirect(req.getContextPath()+ page);
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
        }*/
    }
}
