package com.rigin.web.servlet;

import com.rigin.model.dto.UserLogInDto;
import com.rigin.model.entity.Task;
import com.rigin.service.LogInServer;
import com.rigin.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.rigin.constant.Constants.*;

@Slf4j
@WebServlet("/login")
public class UserLogInServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login_user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        LogInServer logInServer = new LogInServer(userService);
        Optional<UserLogInDto> user = logInServer.getUserByPasswordAndEmail(email, password);

        if (user.isPresent()) {
            long userId = user.get().getId();
            log.info("The user is found: {}", user.get());
            req.getSession().setAttribute("userId", userId); // Store userId in the session

            Set<Task> tasksSet = userService.getUsersAndTheirTasks(userId);
            List<Task> tasks = new ArrayList<>(tasksSet);
            log.info("Fetched tasks for user {}: {}", userId, tasks.toString());
            req.setAttribute("tasks", tasks);
            getServletContext().getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
        } else {
            log.info(USER_NOT_FOUND);
            req.setAttribute("error", USER_NOT_FOUND); // Use a more descriptive attribute name
            resp.sendRedirect("/register.jsp");
//            req.getRequestDispatcher("/register.jsp").forward(req, resp); // Forward back to login_user.jsp to show error
        }

    }
}
