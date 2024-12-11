package com.rigin.web.servlet;

import com.rigin.model.dto.UserSignInDto;
import com.rigin.model.entity.User;
import com.rigin.model.mapper.UserMapper;
import com.rigin.provider.PropertiesSessionProvider;
import com.rigin.provider.SessionProvider;
import com.rigin.repository.UserRepository;
import com.rigin.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;
@WebServlet("/register")
public class UserSignInServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserSignInDto userSignInDto=UserSignInDto.builder()
                .name(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
        User user = UserMapper.INSTANCE.registerUser(userSignInDto);

        var userFind=userService.getAll().stream().filter(x->x.getEmail().equals(email)).findFirst();
        if(userFind.isPresent()){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
        }
        else{
            userService.save(user);
            long id=(userService.getUserByEmailAndPassword(email,password)).get().getId();
            req.setAttribute("id",id);
            req.setAttribute("NOTIFICATION", "User Registered Successfully!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/userCabinet.jsp");
            dispatcher.forward(req, resp);
        }

    }
    @Override
    public void destroy() {

    }
}
