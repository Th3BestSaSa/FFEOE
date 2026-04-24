<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado del Cálculo</title>
</head>
<body>
    <%
        // 1. Recuperar los datos del formulario (vienen como String)
        int dia = Integer.parseInt(request.getParameter("dia"));
        int mes = Integer.parseInt(request.getParameter("mes"));
        int anio = Integer.parseInt(request.getParameter("anio"));

        // 2. Crear el calendario (Ojo: en Java los meses empiezan en 0, Enero = 0)
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);

        // 3. Obtener el nombre del día de la semana
        String[] diasNombre = {"domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
        String nombreDia = diasNombre[calendario.get(Calendar.DAY_OF_WEEK) - 1];

        // 4. Comprobar si es bisiesto
        boolean esBisiesto = calendario.isLeapYear(anio);
        String mensajeBisiesto = esBisiesto ? "SÍ es bisiesto" : "NO es bisiesto";
    %>

    <h2>Resultado:</h2>
    <p>Día: <%= dia %></p>
    <p>Mes: <%= mes %></p>
    <p>Año: <%= anio %></p>
    
    <p>El día de la semana es <strong><%= nombreDia %></strong>, 
       y el año <%= anio %> <strong><%= mensajeBisiesto %></strong>.</p>

    <a href="formularioCalculoDia.html">Volver atrás</a>
</body>
</html>