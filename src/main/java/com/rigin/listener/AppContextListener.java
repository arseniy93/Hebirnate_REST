package com.rigin.listener;

import com.rigin.provider.PropertiesSessionProvider;
import com.rigin.provider.SessionProvider;
import com.rigin.repository.ActivityRepository;
import com.rigin.repository.CommentRepository;
import com.rigin.repository.TaskRepository;
import com.rigin.repository.UserRepository;
import com.rigin.service.TaskService;
import com.rigin.service.UserService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

@Slf4j
@WebListener
public class AppContextListener implements ServletContextListener {
    private SessionFactory sessionFactory;
    private UserRepository userRepository;
    private ActivityRepository activityRepository;
    private TaskRepository taskRepository;
    private CommentRepository commentRepository;
    private UserService userService;

    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SessionProvider sessionProvider = new PropertiesSessionProvider();
        sessionFactory = sessionProvider.getSessionFactory();
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("sessionFactory",sessionFactory);
        userRepository= new UserRepository(sessionFactory);
        ctx.setAttribute("userRepository",userRepository);
        taskRepository=new TaskRepository(sessionFactory);
        ctx.setAttribute("taskRepository",taskRepository);
        activityRepository=new ActivityRepository(sessionFactory);
        ctx.setAttribute("activityRepository",activityRepository);
        commentRepository=new CommentRepository(sessionFactory);
        ctx.setAttribute("commentRepository",commentRepository);
        if(userRepository==null){
            throw new RuntimeException("userRepository Null");
        }
        userService = new UserService(userRepository,taskRepository,activityRepository,commentRepository);
        ctx.setAttribute("userService", userService);

        System.out.println("Database connection initialized and UserService is ready.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Clean up resources if necessary
        sessionFactory.close();
        log.info("Cleaning up resources...");
        System.out.println("Cleaning up resources...");
        log.info("Session factory is closed: " + sessionFactory.isClosed());
        System.out.println("Session factory is closed: " + sessionFactory.isClosed());
    }

}
