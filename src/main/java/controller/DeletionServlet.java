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

@WebServlet(urlPatterns = {"/delete"})
public class DeletionServlet extends HttpServlet
{
    private final Laptops laptops = new Laptops();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int laptopsID = Integer.parseInt(req.getParameter("laptopsID"));

        try
        {
            laptops.removeLaptopsById(laptopsID);

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
