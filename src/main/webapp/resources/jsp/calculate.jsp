<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<html>
<head>
    <title>Calculator</title>
    <link href="<c:url value="/css/page_view.css"/>" type="text/css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 style="color:#ff0000">Посчитай что-нибудь!: </h1>
    </div>

        <div class="container">
            <p style="color:#ff0000" id="valid_mess"></p>
        </div>
        <div class="container">

            <sf:form method="post" modelAttribute="newOper" action="calc/do_math">

                    <sf:label path="firstNumber">Enter first digit: </sf:label>
                    <sf:input path="firstNumber"/>
                    <sf:errors path="firstNumber"/>

                <br/>
                <br/>

                    <sf:label path="operation">Enter operation: </sf:label>
                    <sf:input path="operation"/>
                    <sf:errors path="operation"/>

                <br/>
                <br/>

                    <sf:label path="secondNumber">Enter second digit: </sf:label>
                    <sf:input path="secondNumber"/>
                    <sf:errors path="secondNumber"/>

                <br/>
                <br/>
                    <input type="submit" value="Calculate"/>
            </sf:form>

        </div>


        <div class="container">
            <p style="color:#ff0000">Last result:</p> ${result}
        </div>

</body>
</html>