<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/bootstrap/css/respon.css" crossorigin="anonymous">
<style>
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
</style>

<script>
	$(function(){
		$(document).on(
				"click",
				".data_list",
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

	})
	
</script>
</head>
<body>
		<div class="jumbotron">
        <h1>테스트넷 v2</h1>
        <p class="lead">이것저것 테스트 하기 위해 만들어봄.</p>
        <a class="btn btn-large btn-success" href="#">Get started today</a>
      </div>
      
      <div class="content">
         <div class="row-fluid">
        <div class="span6">
          <h2>내블로그 최근등록한 글</h2>
         <table class="table table-hover">
         	<thead><tr><td>내용</td><td>작성</td></tr></thead>
         	<tbody>
		       <c:forEach var="data" items="${list}">
					<tr class="data_list" id="${data.url}">
						<td>${data.subject}</td><td>${data.name}</td>
					</tr>
				</c:forEach>
			</tbody>
         </table>
          <p><a class="btn" href="https://jihazarrd.tistory.com" id="checkAll" >블로그가기</a></p>  
      </div>
      
         <div class="span6">
          <h2>탭2</h2>
         <table class="table table-hover">
         	<thead><tr><td>내용</td><td>작성</td></tr></thead>
         	<tbody>
		       <c:forEach var="data" items="${list}">
					<tr class="data_list" id="${data.url}">
						<td>${data.subject}</td><td>${data.name}</td>
					</tr>
				</c:forEach>
			</tbody>
         </table>
          <p><a class="btn" href="https://jihazarrd.tistory.com" id="checkAll" >블로그가기</a></p>  
      </div>
  	
    

</body>
</html>