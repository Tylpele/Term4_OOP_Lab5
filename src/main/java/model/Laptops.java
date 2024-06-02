package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Laptops
{
    private Database database;

    public static final String DB_URL = "jdbc:mysql://localhost:3306/dblaptops";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "root";

    public List<Laptop> getLaptops() throws SQLException
    {
        List<Laptop> laptopsList = new ArrayList<>();

        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        ResultSet resultSet = database.executeQuery("SELECT model, processor, RAM, storage_drive, display, price, laptopsID FROM laptops");
        while (resultSet.next())
        {
            laptopsList.add(new Laptop(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getInt(7)
            ));
        }

        return laptopsList;
    }

    public void addLaptop(Laptop laptop) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("INSERT INTO laptops (model, processor, RAM, storage_drive, display, price) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                        laptop.getModel(), laptop.getProcessor(), laptop.getRAM(), laptop.getStorage_drive(), laptop.getDisplay(), laptop.getPrice()));

        database.closeConnection();
    }

    public void removeLaptopsById(int laptopsID) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("DELETE FROM laptops WHERE laptopsID=%d", laptopsID));

        database.closeConnection();
    }

    public void updateLaptopById(int laptopsID, Laptop newCar) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("UPDATE laptops SET model='%s', processor='%s', RAM='%s', storage_drive='%s', display='%s', price='%s' WHERE laptopsID=%d",
                newCar.getModel(), newCar.getProcessor(), newCar.getRAM(), newCar.getStorage_drive(), newCar.getDisplay(), newCar.getPrice(), laptopsID));

        database.closeConnection();
    }
}
