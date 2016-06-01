<%--
  Created by IntelliJ IDEA.
  User: sunil
  Date: 5/30/16
  Time: 8:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <p>The first name to print 10 times is:<% int i = 0;
            while(i<10 ){

                out.println(request.getAttribute("firstName"));
                i++;

            }  %></p>
</body>
</html>
