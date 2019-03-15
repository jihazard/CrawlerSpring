
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>

<style>
.grid-item {
  float: left;
  width: 400px;
  height: 260px;
  border: 2px solid hsla(0, 0%, 0%, 0.5);
}

.grid-item--width2 {
	width: 200px;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<script
	src="https://unpkg.com/infinite-scroll@3/dist/infinite-scroll.pkgd.min.js"></script>
<link href="https://unpkg.com/nes.css@2.1.0/css/nes.min.css"
	rel="stylesheet" />
<script>
	$(document)
			.ready(
					function() {
						var $grid = $('.grid').masonry({
							// options
							itemSelector : '.grid-item',
							fitWidth : true,
						});
						
						var msnry = $grid.data('masonry');

						$(document)
								.on(
										"click",
										".grid-item",
										function() {
											var no = $(this).attr("id");
											var url = no;
											window
													.open(
															url,
															"bob",
															"_blank",
															"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400");
										})

						var page = 1;

			/* 			$(window)
								.scroll(
										function() {
											if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
												alert("로딩중");
												$("#map1")
														.append("<div class='grid-item'>추가됨1</div>");
											}
										}); */
						
										var data = JSON.parse(fn_getJsonData("/best"));
						 	
			 			 $.each(data,function(k,v){
						 
						 var div = document.createElement('div');
						 div.className = "grid-item"
						 div.id = v.url
						 div.innerHTML = "<span>"+v.subject+"</span><br><span>"+v.name+" "+v.date+"</span>"
						
						 document.getElementById("map1").appendChild(div);
						 
						 }) 
					})
					

	function fn_getJsonData(url) {
		return $.ajax({
			url : url,
			type : "POST",
			async : false,

			success : function(data, textStatus, jqXHR) {
				console.log(data);

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown + " " + textStatus);
			}

		}).responseText;
	}
</script>

<title>Home</title>
</head>
<body>
	<h1>베오베</h1>

	<div id="map1" class="grid">
<%-- 		<c:forEach var="data" items="${data}">
			<div class="grid-item" data-num="${data.no}">
				<span style="text-align: center;">${data.subject}</span><br /> <span>${data.name}</span>
				<span>${data.date}</span>
			</div>

		</c:forEach>  --%>

	</div>

</body>
</html>
