package app.web.servlets;

import app.services.base.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars/all")
public class CarsAllServlet extends HttpServlet {

    private final CarService carService;

    @Inject
    CarsAllServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("allCars", this.carService.getAllCars());

        req.getRequestDispatcher("/cars-all.jsp")
                .forward(req, resp);
    }
}
