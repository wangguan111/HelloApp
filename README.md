# HelloApp
Pratice and study the java servlet.

3.2 Cerate the first web

	url:http://localhost:8080/HelloApp/login.htm

	code:3-1,3-2,3-3

	1.doGet and doPost in the Servlet
	2.url
	3.new initParams setting method in servlet3.0
	4.getParameter from the request


4.4.1 Share the data in the web

	url:http://localhost:8080/HelloApp/counter

	code:4-8,4-9

	1.getAttribute and setAttribute to share the date in the web
	2.loadOnStartup
	3.setContentType


4.4.2 Listener
	
	code:4-11

	1.contextInitialized
	2.contextDestroyed
	3.getResourceAsStream,getRealPath


5.6 Forward and include

	url:http://localhost:8080/HelloApp/check?username=Tom

	code:5-9,5-10

	1.RequestDispatcher
	2.two getRequestDispatcher method
	3.forward

	url:http://localhost:8080/HelloApp/main?username=Tom

	code:5-11,5-14

	1.RequestDispatcher
	2.include


5.7 Redirect

	url:http://localhost:8080/HelloApp/check1

	code:5-15,5-16

	1.sendRedirect
	2.setAttribute,getAttribute is invalid
	3.getParameter is still valid


5.8 Access the other web app in the servlet
	
	code:5-17

	1.access the other web in the servlet


20.1 Filter

	url:http://127.0.0.1:8080/HelloApp/note

	code:20-1,20-2

	1.doFilter


20.4 Series filter

	url:http://127.0.0.1:8080/HelloApp/note

	code:20-4,20-5,20-6


23 Struts2

	url:http://127.0.0.1:8080/HelloApp/index.jsp

	code:23-1,23-2,23-3,23-4,23-5

	1.struts2
	2.mvc
	3.add the jar in the lib
	4.web.xml, struts.xml


25.3 MemoryReal

	url:any

	code:25-1,25-2,25-3,25-4

	1.tomcat
	2.j_security_check,j_username,j_password
	3.web.xml
	4.tomcat-users.xml


28 Tomcat

	url:any

	code:28-1

	1.server.xml
	2.AccessLogValve
	3.RemoteAddrValve,RemoteHostValve
	4.RequestDumperValue
