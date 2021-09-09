<%@page import="java.util.*" %>     
<HTML>     
<HEAD>     
<TITLE>JSP Example</TITLE>     
</HEAD>     
<BODY BGCOLOR="#ffffcc">     
<CENTER>     
<H2>Date and Time</H2>     
Today's date is: <%= new Date() %>     
</CENTER>     
</BODY>     
</HTML>

<HTML>     
<HEAD>     
<TITLE>Form Example</TITLE>     
</HEAD>     
<BODY BGCOLOR="#ffffcc">     
<% if (request.getParameter("name")==
null && request.getParameter("email")
 == null) { %>     
<CENTER>     
<H2>User Info Request Form</H2>     
<FORM METHOD="GET" ACTION="/developer/technicalArticles/xml/WebAppDev/process.jsp">     
<P>     
Your name: <input type="text" name=
"name" size=26>     
<P>     
Your email: <input type="text" name=
"email" size=26>     
<P>     
<input type="submit" value="Process" ACTION="C:\Apache Software Foundation\Tomcat 8.5\webapps\DevOps_final_project\page2">     
</FORM>     
</CENTER>     
<% } else { %>     
<%! String name, email; %>     
<%     
name = request.getParameter("name");     
email = request.getParameter("email");     
%>     



