<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Access at: http://localhost:8080/TestBaristamaticSpring3Mvc/welcome -->
<html>
<head>
<title>Main</title>
</head>
<body>
<h2>Welcome Ace</h2>
Today is
<fmt:formatDate value="${today}" pattern="dd-MM-yyyy" />
</body>
</html>