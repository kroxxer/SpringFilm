<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Film</title>
</head>
<body>


    <form:form action="/films/save/" commandName="film" method="post">
        <table>
            <c:if test="${!empty film.name}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID : "/>
                        </form:label>
                    </td>
                    <td>
                        <form:hidden path="id" />
                    </td>
                </tr>

            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Film Name : "/>
                    </form:label>
                </td>

                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="genre">
                        <spring:message text="Film Genre : " />
                    </form:label>
                </td>

                <td>
                    <form:select path="genre" size="1">
                        <form:option disabled="true" value=" ">Choose a genre</form:option>
                        <form:option value="action">Action</form:option>
                        <form:option value="horror" selected="true">Horror</form:option>
                        <form:option value="noir">Noir</form:option>
                        <form:option value="arthouse">Arthouse</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="date">
                        <spring:message text="Film Year : " />
                    </form:label>
                </td>

                <td>
                    <form:input path="date"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="image_url">
                        <spring:message text="Film Image : " />
                    </form:label>
                </td>

                <td>
                    <form:input path="image_url"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save" class="save">
                </td>
            </tr>
        </table>

    </form:form>

</body>
</html>
