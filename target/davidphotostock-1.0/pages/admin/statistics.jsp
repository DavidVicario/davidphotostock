<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Estadisticas</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/admin_style.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <style>
        .statis-f{
            background-color: var(--blackBase);
            margin: 5% auto 0 5%;
            border: 1px solid var(--whiteBase);
            width: 600px;
            flex-direction: column;
        }
        .statis-r{
            background-color: var(--blackBase);
            margin: 0 auto 0 5%;
            border: 1px solid var(--whiteBase);
            width: 600px;
            flex-direction: column;
        }
        .btn-stat{
            background-color: var(--orangeBase);
            color: var(--whiteBase);
            padding: 15px 0;
            margin: 20px;
            border: 1.5px solid var(--whiteBase);
            cursor: pointer;
            width: 50%;
        }
        .btn-stat:hover{
            background-color: var(--orangeHovr);
        }
        .table-range{
            width: 90%;
            margin: 10px 5% 30px 5%;
        }
    
        
    </style>
</head>
    <header class="header-admin">
        <div class="title-admin">
            <h1>STATISTICS</h1>
            <a class="logout-admin" href="/UsersAdminServlet">Admin panel</a>
        </div>
    </header>
    <body>
        <div class="statis-f">
            <h2 style="color: white; margin:20px;">Envios realizados: ${finishedShipments}</h2>
            <h2 style="color: white; margin:20px;">Envios en proceso: ${unfinishedShipments}</h2>
        </div>
        
        <form class="statis-r" style="color: white; padding-top: 20px" action="/UsersAdminServlet?action=statistics" method="post">
            <label style="color: white; margin:20px;" for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate">

            <!-- Date input for the end date -->
            <label style="color: white; margin:20px;" for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate">
            <button class="btn-stat" type="submit">LISTAR</button>
        </form>
        <div class="statis-r">
            <h2 style="color: white; margin:20px;">Envios entre las fechas:</h2>
            <p style="color: white; margin:20px;">Envios Totales: ${shipmentsInRangeCount}</p>
        </div>
        <table class="table-range">
            <tr style="color: white;">
                <th>Shipment ID</th>
                <th>Finished</th>
                <th>Address</th>
                <th>Date</th>
                <!-- Add more columns as needed -->
            </tr>
            <c:forEach items="${shipmentsInRange}" var="shipment">
                <tr style="color: white;">
                    <td>${shipment.idShipment}</td>
                    <td>${shipment.finished}</td>
                    <td>${shipment.address}</td>
                    <td>${shipment.shipmentDate}</td>
                    <!-- Add more data as needed -->
                </tr>
            </c:forEach>
        </table>
    </body>
    <script src="/assets/js/admin.js"></script>
</html>