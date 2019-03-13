
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>

<style>
.grid-item { width: 400px; border: 1px solid gray;margin: 0 auto;}
.grid-item--width2 { width: 200px; }
  html, body, pre, code, kbd, samp, div{
          font-family: "font-family you want to use";
      }
</style>
<script
			  src="https://code.jquery.com/jquery-3.3.1.min.js"
			  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			  crossorigin="anonymous"></script>
<script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<link href="https://unpkg.com/nes.css@2.1.0/css/nes.min.css" rel="stylesheet" />
<script>
$(document).ready(function(){
		$('.grid').masonry({
			  // options
			  itemSelector: '.grid-item',
			  fitWidth: true,
			  columnWidth: 100
			});

		
/* 	var data = JSON.parse(fn_getJsonData("/best"));
		$.each(data,function(k,v){
			console.log(k+"//"+v)
			
		})  */
		

/* 	 	$.post("/best",function(data){
			
				$.each(data, function(idx, itm) {
					if(idx==10) alert(idx+"/"+itm.subject+"/"+itm.name+"/"+itm.date)
					var div = document.createElement('div');
					div.className = ".grid-item"
					div.id = "grid" + idx
					document.getElementById("map1").appendChild(div);
				
					 
			

				
			})
		})		 */
	})
	
 function fn_getJsonData(url){
	return $.ajax({ 
		    url : url  ,	
 			type:"POST",             			
 			async: false,
 			
 			success: function(data, textStatus, jqXHR)
 			{                   	  	
	            console.log( data );    
 				
 			},
 			error: function (jqXHR, textStatus, errorThrown)
 			{                        
	 			alert(errorThrown + " " + textStatus);
 			}

	}).responseText;
} 


</script>

	<title>Home</title>
</head>
<body>
<h1>
	 bob
</h1>

<div id="map1" class="grid">
<c:forEach var="data" items="${data}">
	<div class="grid-item" data-no="${data.no}">
		<span>${data.subject}</span><br />
		<span>${data.name}</span>
		<span>${data.date}</span>${data.no}
	</div>

</c:forEach>


</body>
</html>
