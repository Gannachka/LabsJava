<%@ page import="classespack.Regimex" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%! String name=null; // тег для объявления
        Regimex regimex = new Regimex();
        Integer n = regimex.GetHOUR();

        protected String Salutation(Integer h){
            String rc="Good ";
            if((h>0) && (h<=5))
                rc+="night";
            else if((h>5) && (h<=12))
                rc+="morning";
            else if((h>12)&&(h<=17))
                rc+="afternoon";
            else
                rc+="evening";
            return rc;
        }

        protected String TableOfWeek(Integer amountOfDays)
        {
            regimex =new Regimex();
            String Table="<table border=\"2\">";
            for (int i=0;i<amountOfDays;i++) {
                Table += "<tr>" +
                        "<td>" +
                        regimex.GetCurrentDate() +
                        "</td>" +
                        "<td>" +
                        regimex.GetDayOfWeek() +
                        "</td>" +
                        "</tr>" ;
                regimex.AddDay();
            }
            Table+= "</table></br></br>";
            return Table;
        }
    %>
</head>
<body>
    <%=Salutation(n)%>// выр
    <%=TableOfWeek(7)%>
    <br>
    <form>
        <button type="submit" name="time1" style="height: 70px; width: 150px" value="inc">GetCurrentTimeInclude</button>
    </form>
    <% if("inc".equals(request.getParameter("time1"))){%>//скр
        <%if((n>0) && (n<=5)){%>
            <jsp:include page="night.jsp"/>
        <%}else if((n>5) && (n<=12)){%>
            <jsp:include page="morning.jsp"/>
        <%}else if((n>12)&&(n<=17)){%>
            <jsp:include page="/afternoon"/>
        <%}else
            {%>
            <jsp:include page="evening.jsp"/>
        <%}%>
    <%}%>
    <br>
    <form>
        <button type="submit" name="time2" style="height: 70px; width: 160px" value="for">GetCurrentTimeForward</button>
    </form>
    <% if("for".equals(request.getParameter("time2"))){%>
    <%if((n>0) && (n<=5)){%>
    <jsp:forward page="night.jsp"/>
    <%}else if((n>5) && (n<=12)){%>
    <jsp:forward page="morning.jsp"/>
    <%}else if((n>12)&&(n<=17)){%>
    <jsp:forward page="/afternoon"/>
    <%}else {%>
    <jsp:forward page="evening.jsp"/>
    <%}%>
    <%}%>
    <br>
    <a href="Jjj">Call Jjj</a></br></br>
    <form action="Jjj" method="post">
        <input type="text" name="hour" value="<%=n%>" />
        <input type = "submit" name="press"  value = "DoPOST"  size = "20"/>
    </form>
</body>
</html>
