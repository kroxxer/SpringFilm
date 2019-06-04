<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>

    <head>
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="<spring:url value="css/loginstyle.css" />" />

    </head>

    <body>

        <section class="container">
            <div class="login">

                <h1>Войти в личный кабинет</h1>

                <%--@elvariable id="user" type=""--%>
                <form:form action="/login/sign" commandName="user" >

                    <p>
                        <form:label path="name" >
                            <spring:message text="Login : " />
                        </form:label>
                        <form:errors path="name" />
                    </p>
                    <p>
                        <form:input path="name" />
                    </p>

                    <p class="submit">
                        <input type="submit" value=<spring:message text="Войти"/> />
                    </p>

                </form:form>

            </div>
        </section>
    </body>
</html>
