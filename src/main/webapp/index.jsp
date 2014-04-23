<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>15 puzzle</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/gameservlet">
<div align="center">
<input name="b1" type="submit" class="mybutton" value="<%= session.getAttribute("b1") != null ? session.getAttribute("b1") : "1"  %>">
<input name="b2" type="submit" class="mybutton" value="<%= session.getAttribute("b2") != null ? session.getAttribute("b2") : "2"  %>">
<input name="b3" type="submit" class="mybutton" value="<%= session.getAttribute("b3") != null ? session.getAttribute("b3") : "3"  %>">
<input name="b4" type="submit" class="mybutton" value="<%= session.getAttribute("b4") != null ? session.getAttribute("b4") : "4"  %>">
<br>
<input name="b5" type="submit" class="mybutton" value="<%= session.getAttribute("b5") != null ? session.getAttribute("b5") : "5"  %>">
<input name="b6" type="submit" class="mybutton" value="<%= session.getAttribute("b6") != null ? session.getAttribute("b6") : "6"  %>">
<input name="b7" type="submit" class="mybutton" value="<%= session.getAttribute("b7") != null ? session.getAttribute("b7") : "7"  %>">
<input name="b8" type="submit" class="mybutton" value="<%= session.getAttribute("b8") != null ? session.getAttribute("b8") : "8"  %>">
<br>
<input name="b9" type="submit" class="mybutton" value="<%= session.getAttribute("b9") != null ? session.getAttribute("b9") : "9"  %>">
<input name="b10" type="submit" class="mybutton" value="<%= session.getAttribute("b10") != null ? session.getAttribute("b10") : "10"  %>">
<input name="b11" type="submit" class="mybutton" value="<%= session.getAttribute("b11") != null ? session.getAttribute("b11") : "11"  %>">
<input name="b12" type="submit" class="mybutton" value="<%= session.getAttribute("b12") != null ? session.getAttribute("b12") : "12"  %>">
<br>
<input name="b13" type="submit" class="mybutton" value="<%= session.getAttribute("b13") != null ? session.getAttribute("b13") : "13"  %>">
<input name="b14" type="submit" class="mybutton" value="<%= session.getAttribute("b14") != null ? session.getAttribute("b14") : "14"  %>">
<input name="b15" type="submit" class="mybutton" value="<%= session.getAttribute("b15") != null ? session.getAttribute("b15") : "15"  %>">
<input name="b16" type="submit" class="mybutton" value="<%= session.getAttribute("b16") != null ? session.getAttribute("b16") : " "  %>">
</form>
</div>
</body>
</html>