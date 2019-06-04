
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Films</title>

        <link rel="stylesheet" type="text/css" href="<spring:url value="css/filmstyle.css"/>">

    </head>
    <body>

        <br>

        <h2 class="logo" style="display: inline;">Films List</h2>
        <br>

        <form:form action="/logout" cssStyle="text-align: right;">
            <p>Name User : ${user.name}</p>

            <p>Is Admin :

            <c:if test="${user.admin}">
                <span class="circle on"></span>
            </c:if>
            <c:if test="${!user.admin}">
                <span class="circle off"></span>
            </c:if>
            </p>
            <input type="submit" value="Log Out">
        </form:form>

        <br>

        <c:if test="${user.admin}">
            <a class="add" target="_self" href="films/add">+</a>
        </c:if>

        <br>

        <c:if test="${!empty listFilms}">
            <table class="tb_list">
                <tr>
                    <th width="60">Film ID</th>
                    <th width="180">Film Name</th>
                    <th width="80">Film Genre</th>
                    <th width="80">Film Date</th>
                    <th width="110">Film Image</th>
                </tr>
                <c:forEach items="${listFilms}" var="film">
                    <tr>
                        <td width="60" align="center" style="padding: 5px">${film.id}</td>
                        <td width="180" align="center" style="padding: 5px">${film.name}</td>
                        <td width="80" align="center" style="padding: 5px">${film.genre}</td>
                        <td width="80" align="center" style="padding: 5px">${film.date}</td>
                        <td width="110" align="center" style="padding: 5px">
                            <a href="/films/show/${film.id}" target="_self">
                                <img src="${film.image_url}" width="100px" height="150px">
                            </a>
                        </td>
                        <c:if test="${user.admin}">
                            <td width="80" align="center" style="padding: 5px">
                                <a href="films/edit/${film.id}" target="_self">Edit</a>
                            </td>
                            <td width="80" align="center" style="padding: 5px">
                                <a href="films/delete/${film.id}" target="_self">Delete</a>
                            </td>
                        </c:if>

                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br>

    </body>
</html>
