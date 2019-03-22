
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet"> 
<style>

  body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
  html, body, pre, code, kbd, samp {
          font-family: 'Press Start 2P', cursive,'둥근모꼴';
      }
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/bootstrap/css/respon.css" crossorigin="anonymous">


<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>

<!-- <link href="https://unpkg.com/nes.css@2.1.0/css/nes.min.css"
	rel="stylesheet" />
 -->	
	
<script>
	$(document)
			.ready(
					function() {
						
						
						
						var $grid = $('.grid').masonry({
							// options
							itemSelector : '.grid-item',
							fitWidth : true,
						});
						
						
						$("#checkAll").click(function() {
							$("input[name=box]:checkbox").each(function() {
								$(this).attr("checked", true);
							});
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
						 div.innerHTML = "<span>"+v.subject+"</span><br><span>"+v.name+" "+v.date+"[" +v.type+"]</span>"
						
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


    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar">1</span>
            <span class="icon-bar">2</span>
            <span class="icon-bar">3</span>
          </button>
          <a class="brand" href="#">bob</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>


	
    <div class="container">
        <div class="hero-unit">
        <h1>BMS</h1>
        <p>자바 크롤링 연습사이트맨 </p>
      
      </div>
    
    
	
	
	     <div class="row">
        <div class="span4">
          <h2>크롤링사이트</h2>  
              <div>
     				<input type="checkbox" class="checkbox" name="box" value="" />오늘의유머 <br>
     				<input type="checkbox" class="checkbox" name="box" value=""/>웃대
     				
   			 </div>
          <p> </p>
          <p><a class="btn" href="#" id="checkAll">전체선택</a></p>
        </div>
        <div class="span8">
          <h2>베스트</h2><br />
            <p><a href="#" class="btn btn-primary btn-small">이전</a><a href="#" class="btn btn-primary btn-small">다음</a></p>
          <div id="map1" class="grid">
       </div>
        

    
	
<!-- 	   <footer>
        <p>&copy; 연습용</p>
      </footer> -->
</div>
</body>
</html>
