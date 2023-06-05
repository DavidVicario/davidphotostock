<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%
    String title = request.getParameter("title");
    String description1 = request.getParameter("description1");
    String image = request.getParameter("image");
%>

<div class="subheader-image checkout" style="background-image:url('<%= image %>');">
    <div class="subheader-text">
        <h1><%= title %></h1>
        <p><%= description1 %></p>
    </div>
</div>