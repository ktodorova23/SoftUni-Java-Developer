package app.web.servlets;

import app.domain.models.CarServiceModel;
import app.services.base.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars/create")
public class CarCreateServlet extends HttpServlet {

    private final CarService carService;

    @Inject
    CarCreateServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cars-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarServiceModel carModel = new CarServiceModel();

        carModel.setBrand(req.getParameter("brand"));
        carModel.setModel(req.getParameter("model"));
        carModel.setYear(Integer.parseInt(req.getParameter("year")));
        carModel.setEngine(req.getParameter("engine"));

        try {
            this.carService.createCar(carModel);
            resp.sendRedirect("/home");
        } catch (IllegalAccessException e) {
            resp.sendRedirect("/users/login");
        }
    }
}
