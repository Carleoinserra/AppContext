<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "app.utente"%>
<%
ArrayList<utente> lista= (ArrayList)request.getAttribute("lista");

if (lista == null){
	out.print("E' null");
}
else {
for (int i = 0; i < lista.size(); i++){
	
	out.print(lista.get(i).getEmail());
	
	out.print(lista.get(i).getNome());
	out.print("<br>");
	
}}

%>
</body>
</html>