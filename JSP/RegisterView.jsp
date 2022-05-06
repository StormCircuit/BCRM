<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p id="1" onclick="addActivity(1);"> Water Lining </p>
<p id="2" onclick="addActivity(2);"> Key Log Rolling</p>
<p id="3" onclick="addActivity(3);"> Open Water Polo</p>
<p id="4" onclick="addActivity(4);"> Water Basketball</p>
<p id="5" onclick="addActivity(5);"> Water Volleyball</p>
<p id="6" onclick="addActivity(6);"> FitFloat Relax Time</p>	
	
<button onclick="/Cart.jsp"> Checkout </button>


<script>

function addActivity(i){
	if(i == 1)
		document.getElementById("1").style.color = "red";
	else if(i == 2)
		document.getElementById("2").style.color = "orange";
	else if(i == 3)
		document.getElementById("3").style.color = "yellow";
	else if(i == 4)
		document.getElementById("4").style.color = "green";
	else if(i == 5)
		document.getElementById("5").style.color = "blue";
	else if(i == 6)
		document.getElementById("6").style.color = "indigo";	
}

</script>

</body>
</html>