<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%
    String title = request.getParameter("title");
    String description1 = request.getParameter("description1");
    String description2 = request.getParameter("description2");
    String description3 = request.getParameter("description3");
    String image = request.getParameter("image");
%>

<div class="subheader-image" style="background-image:url('<%= image %>');">
    <div class="subheader-text">
        <h1><%= title %></h1>
        <p><%= description1 %></p>
        <p><%= description2 %></p>
        <p><%= description3 %></p>
    </div>
</div>