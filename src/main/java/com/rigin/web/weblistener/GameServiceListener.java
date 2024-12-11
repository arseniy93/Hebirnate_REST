package com.rigin.web.weblistener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class GameServiceListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext ctx = sce.getServletContext();
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
//        UserValidator userValidator = new UserValidator();
//        GameServiceFacade gameServiceFacade=new GameServiceFacade();

//        UserService userService = new UserService(userValidator, resourceBundle);
//        ctx.setAttribute(USER_SERVICE, userService);
//        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContextListener.super.contextDestroyed(sce);
    }
}
