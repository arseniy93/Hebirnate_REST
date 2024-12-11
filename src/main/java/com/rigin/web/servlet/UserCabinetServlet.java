package com.rigin.web.servlet;

import com.rigin.enums.TasksList;
import com.rigin.model.entity.Task;
import com.rigin.model.entity.User;
import com.rigin.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@WebServlet("/user/tasks/")
public class UserCabinetServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }
    //TODO
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long userId = (Long) req.getSession().getAttribute("userId"); // Example
//        if(userId != null) {
//            Set<Task> tasksSet = userService.getUsersAndTheirTasks(userId);
//            List<Task> tasks = new ArrayList<>(tasksSet);
//            req.setAttribute("tasks", tasks);
//
//            log.info("Fetched tasks for user {}: {}", userId, tasks != null ? tasks.size() : "null");
//            req.setAttribute("tasks", tasks != null ? tasks : Set.of());
//            getServletContext().getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
//           // req.getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
//        } else {
//            resp.sendRedirect(req.getContextPath() + "/login_user.jsp");
//        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("userId");
        if (userId != null) {
            // Логика обновления задачи
            resp.setContentType("application/json");
            resp.getWriter().write("{\"success\": true}");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("userId");
        if (userId != null) {
            String pathInfo = req.getPathInfo();
            if (pathInfo != null && pathInfo.length() > 1) {
                Long taskId = Long.parseLong(pathInfo.substring(1));
                userService.deleteTask(taskId);
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("userId");
        var user = userService.getUserById(userId);
        Task task = new Task();
        task.setTitle(req.getParameter("title")); // Используем title из формы
        task.setDescription(req.getParameter("description")); // Используем description из формы
        task.setTasksList(req.getParameter("status")); // Используем status из формы
        task.setUser(user.get());
        userService.createTask(task);
        resp.sendRedirect("/user/tasks/");
    }

}
