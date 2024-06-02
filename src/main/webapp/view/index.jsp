<%@ page import="model.Laptop" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Laptop" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Автомобили</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1 class="mb-4">Характеристики ноутбуков</h1>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Модель</th>
            <th scope="col">Процессор</th>
            <th scope="col">Оперативная память</th>
            <th scope="col">Накопитель</th>
            <th scope="col">Экран</th>
            <th scope="col">Цена, $</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <% List<Laptop> laptopsList = (List<Laptop>) request.getAttribute("laptopsList");
            for (Laptop laptop : laptopsList) { %>
        <tr>
            <td><%= laptop.getModel() %></td>
            <td><%= laptop.getProcessor() %></td>
            <td><%= laptop.getRAM() %></td>
            <td><%= laptop.getStorage_drive() %></td>
            <td><%= laptop.getDisplay() %></td>
            <td><%= laptop.getPrice() %></td>
            <td><a href="edit?laptopsID=<%= laptop.getId() %>" class="btn btn-primary"><i class="fas fa-pencil-alt"></i></a></td>
            <td><a href="delete?laptopsID=<%= laptop.getId() %>" class="btn btn-outline-danger"><i class="fas fa-trash-alt"></i></a></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <hr style="margin-top: 60px;">

    <div class="container" style="margin-top: 60px; margin-bottom: 100px;">
        <h2>Добавить ноутбук</h2>
        <form action="addition" method="post" id="addition">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="model">Модель:</label>
                    <input type="text" class="form-control" id="model" name="model">
                </div>
                <div class="form-group col-md-6">
                    <label for="processor">Процессор:</label>
                    <input type="text" class="form-control" id="processor" name="processor">
                </div>
                <div class="form-group col-md-6">
                    <label for="RAM">Оперативная память (GB):</label>
                    <input type="text" class="form-control" id="RAM" name="RAM">
                </div>
                <div class="form-group col-md-6">
                    <label for="storage_drive">Накопитель (GB):</label>
                    <input type="text" class="form-control" id="storage_drive" name="storage_drive">
                </div>
                <div class="form-group col-md-6">
                    <label for="display">Экран (дюймы):</label>
                    <input type="text" class="form-control" id="display" name="display">
                </div>
                <div class="form-group col-md-6">
                    <label for="price">Цена ($):</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" id="add">Добавить</button>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
