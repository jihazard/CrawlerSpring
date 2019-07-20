
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P"
	rel="stylesheet">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

html, body, pre, code, kbd, samp {
	font-family: 'Press Start 2P', '둥근모꼴';
}
tbody tr{
	height: 150px;
	}

.title{
	font:bold;
	font-size: 110%;
	color: white;
}

.subTitle {
	font-size: 80%;
}

.faceImg{
	border-radius: 50%;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/bootstrap/css/respon.css"
	crossorigin="anonymous">


<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>

<script>
	var page = 1;
	$(document)
			.ready(
					function() {
						showPageInfo()
						$(document)
								.on(
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

						fn_draw_page()

					})

	function fn_draw_page() {
		var crwlList = [];

		$("input[name='box']:checked").each(function(i) {
			crwlList.push($(this).val());
		})

		if (crwlList.length == 0)
			alert("크롤링할 사이트가 선택되지 않았슴돠")
		else {
			var param = {
				crwlList : crwlList,
				page : page
			}
			var data = JSON.parse(fn_getJsonData("/best", param));

			$.each(data, function(k, v) {

				var div = document.createElement('tr');
				div.className = "data_list"
				div.id = v.url
				
				var status = v.status=='1'? '<span class="badge badge-success">New</span>':'';
				
				div.innerHTML = "<td>"+status +"</td><td><div><p class='title'>"+v.subject+"</p><span class='subTitle'>"
								+v.explain+"</span></div></td><td><div><span><img src="+v.img+"  class='faceImg'></span><span class='writer'>"+v.writer+"</span</div></td><td> " + v.date + "<br>[" + v.type + "]</td>"

				document.getElementById("tbody").appendChild(div);

			})
		}
	}
	function fn_getJsonData(url, param) {
		return $.ajax({
			url : url,
			type : "POST",
			async : false,
			data : param,

			success : function(data, textStatus, jqXHR) {
				//console.log(data);

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown + " " + textStatus);
			}

		}).responseText;
	}

	function check_all() {
		for (i = 0; i < my_form.box.length; i++) {
			my_form.box[i].checked = true;
		}
	}

	function prev() {
		if (page > 1) {
			removeDiv()
			page--;
			fn_draw_page()
			showPageInfo()
		} else
			alert("1페이지 입니다.")

	}
	function next() {
		removeDiv()
		page++;
		fn_draw_page()
		showPageInfo()
	}

	function removeDiv() {
		$("#tbody").empty();
	}

	function showPageInfo() {
		$("#pageinfo").text("< page : " + page + " >")
	}
</script>

<title>Home</title>
</head>
<body>





	<div class="container">
		<div class="hero-unit">
			<h1>200</h1>
			<p>
				200 WE CAN FIND THIS PAGE
			</p>

		</div>




		<div class="row">
			<div class="span4">
				<h2>크롤링사이트</h2>
				<div>
					<form name="my_form">
						<input type="checkbox" class="checkbox" name="box"
							value="woowa" checked="checked" />우아한형제들 <br>
						 <input type="checkbox" class="checkbox" name="box" value="line"
							checked="checked" />라인
					</form>
				</div>
				<p></p>
				<p>
					<a class="btn" href="#" id="checkAll" onclick='check_all();'">전체선택</a>
				</p>
			</div>
			<div class="span8">
				<!-- <h2>베스트</h2>
				<br />
				<p>
					<a href="#" class="btn btn-primary btn-small" onclick='prev();'>이전</a><a
						href="#" class="btn btn-primary btn-small" onclick='next();'>다음</a>
					<span class="label label-success" id="pageinfo">1234</span>
				</p>
				<div id="map1" class="grid"> -->

				<table class="table table-hover">
					<colgroup>
						<col width="10%" />
						<col width="60%" />
						<col width="20%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th>상태</th>
							<th>제목</th>
							<th>등록자</th>
							<th>등록</th>
						</tr>
					</thead>
					<tbody id="tbody">

					</tbody>
				</table>
			</div>




			<!-- 	   <footer>
        <p>&copy; 연습용</p>
      </footer> -->
		</div>
</body>
</html>
