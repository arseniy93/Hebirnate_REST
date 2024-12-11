package com.rigin.web.servlet;

import com.rigin.model.entity.User;
import com.rigin.service.AdministratorService;
import com.rigin.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet("/admin")
public class AdminLogInServlet extends HttpServlet {
    private AdminLogInServlet adminLogInServlet;
    private UserService userService;
    private HttpSession httpSession;

    @Override
    public void init() throws ServletException {
        adminLogInServlet = new AdminLogInServlet();

        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login_admin.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (httpSession == null) {
            var users = userService.getAll();
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            var aminLogin = new AdministratorService();
            if (aminLogin.isAdmin(name, password)) {
                req.setAttribute("users", userService.getAll());
                httpSession = req.getSession();
                httpSession.setMaxInactiveInterval(3600);
                httpSession.getServletContext().setAttribute("admin", name);
                getServletContext().getRequestDispatcher("/adminCabinet.jsp").forward(req, resp);
            } else {
                doGet(req, resp);
            }
        } else {
            var action = req.getParameter("action");

            if (action.equals("delete")) {
                doDelete(req, resp);
            }else if (action.equals("change")) {
                getServletContext().getRequestDispatcher("/update-task.jsp").forward(req, resp);
            }
            else if (action.equals("create")) {
                resp.sendRedirect("/create_task.jsp");
            }
            else {
                getServletContext().getRequestDispatcher("/adminCabinet.jsp").forward(req, resp);
            }
        }

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var idOfUser = req.getParameter("id");
        userService.deleteUserById(Long.valueOf(idOfUser));
        log.info("user with id= " + idOfUser + " was deleted");
        req.setAttribute("users",userService.getAll());
        getServletContext().getRequestDispatcher("/adminCabinet.jsp").forward(req, resp);

    }
}
