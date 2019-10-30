package app.web.servlets;

import app.domain.models.UserServiceModel;
import app.services.base.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService;

    @Inject
    public RegisterServlet(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceModel userModel = new UserServiceModel();
        userModel.setUsername(req.getParameter("username"));
        userModel.setPassword(req.getParameter("password"));
        userModel.setConfirmPassword(req.getParameter("confirmPassword"));
        userModel.setEmail(req.getParameter("email"));

        try {
            this.userService.registerUser(userModel);
            resp.sendRedirect("/index");
        } catch (Exception ex) {
            resp.sendRedirect("/users/register");
        }
    }
}
