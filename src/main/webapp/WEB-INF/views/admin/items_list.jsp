<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
.flex-container {
	display: flex;
	flex-wrap: wrap;
}

.flex-element {
	border-color: white;
	border-style: solid;
	width: 350px;
}
</style>
</head>
<body>
<div class="flex-container">
	<c:forEach items="${itemsList}" var="item">
		<div class="flex-element">
		
		<!--	<h5>${item.id} | ${item.price}$ | ${item.year} | ${item.memory} | ${item.bodyType}</h5> -->
			<img src=${item.image} alt="Red dot" style="width:850px;height:450px;"/>
		<!--	<a href="${item.id}">${item.model}</a> -->
		</div>
		<!--   <div class="row">
							
							<div class="col-md-6">
								<a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
						</div>-->
	</c:forEach>
</div>









<!--  <ul>

	<div class="container">
		
		<div></div>
		
	</div>
		<c:forEach items="${itemsList}" var="item">
		
		<li>${item.id} | ${item.price}$ | ${item.year} | ${item.memory} |  ${item.bodyType} </li>
		
		<div>
    
    <div class="container">
    <div class="row">
    	<div class="col-md-12">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail" >
				
			
    
    <div class="row">
							
							<div class="col-md-6">
								<a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
						</div>

						
    
    <img src=${item.image} alt="Red dot" style="width:200px;height:200px;"/>
    <p> </p>
</div> 
</div>
</div>
</div>
</div>
</div>
		</c:forEach>
	
	</ul>
-->
</body>
</html>