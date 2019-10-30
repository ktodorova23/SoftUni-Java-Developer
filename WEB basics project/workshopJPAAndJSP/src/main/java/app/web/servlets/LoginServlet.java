package app.web.servlets;

import app.domain.models.UserLoginModel;
import app.services.base.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    @Inject
    LoginServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserLoginModel userModel = new UserLoginModel();

        userModel.setUsername(req.getParameter("username"));
        userModel.setPassword(req.getParameter("password"));

        try{
            this.userService.loginUser(userModel);
            resp.sendRedirect("/home");
        } catch (Exception ex) {
            resp.sendRedirect("/users/login");
        }
    }
}
