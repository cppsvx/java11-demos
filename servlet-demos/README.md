# servlet-demos
## What is a Servlet?
A servlet is a Java programming language class that is used to extend the capabilities of 
servers that host applications accessed by means of a request-response programming model. 
Although servlets can respond to any type of request, they are commonly used to extend the 
applications hosted by web servers. For such applications, Java Servlet technology defines 
HTTP-specific servlet classes.

The javax.servlet and javax.servlet.http packages provide interfaces and classes for writing 
servlets. All servlets must implement the Servlet interface, which defines life-cycle methods. 
When implementing a generic service, you can use or extend the GenericServlet class provided 
with the Java Servlet API. The HttpServlet class provides methods, such as doGet and doPost, 
for handling HTTP-specific services.

This chapter focuses on writing servlets that generate responses to HTTP requests.

Via: https://docs.oracle.com/javaee/5/tutorial/doc/bnafe.html

## What is Jersey?
The Jersey RESTful Web Services, formerly Glassfish Jersey, currently Eclipse Jersey framework 
is an open source framework for developing RESTful Web Services in Java. 

It provides support for JAX-RS APIs and serves as a JAX-RS (JSR 311 & JSR 339 & JSR 370) 
Reference Implementation.