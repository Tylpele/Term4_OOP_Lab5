package controller;

import model.Laptop;
import model.Laptops;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/addition"})
public class AdditionServlet extends HttpServlet
{
    private final Laptops laptops = new Laptops();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String model = req.getParameter("model");
        String processor = req.getParameter("processor");
        String RAM = req.getParameter("RAM");
        String storage_drive = req.getParameter("storage_drive");
        String display = req.getParameter("display");
        String price = req.getParameter("price");

        Laptop newLaptop = new Laptop(model, processor, RAM, storage_drive, display, price);

        try
        {
            laptops.addLaptop(newLaptop);

            updatePage(req, resp);
        }
        catch (SQLException e)
        {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка базы данных: " + e.getMessage());
        }
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException
    {
        List<Laptop> laptopsList = laptops.getLaptops();
        req.setAttribute("laptopsList", laptopsList);

        req.getRequestDispatcher("view/index.jsp").forward(req, resp);
    }
}
