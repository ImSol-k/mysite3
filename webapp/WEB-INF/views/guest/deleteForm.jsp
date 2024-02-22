<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/mysite3/assets/css/mysite.css" rel="stylesheet"
	type="text/css">
<link href="/mysite3/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">

</head>

<body>
	<div id="wrap">

		<div id="header" class="clearfix">
			<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
			<!-- //nav -->

			<div id="container" class="clearfix">
				<div id="aside">
					<h2>방명록</h2>
					<ul>
						<li>일반방명록</li>
						<li>ajax방명록</li>
					</ul>
				</div>
				<!-- //aside -->

				<div id="content">

					<div id="content-head">
						<h3>일반방명록</h3>
						<div id="location">
							<ul>
								<li>홈</li>
								<li>방명록</li>
								<li class="last">일반방명록</li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
					<!-- //content-head -->

					<div id="guestbook">
						<form action="/mysite3/guestbook" method="">
							<table id="guestDelete">
								<colgroup>
									<col style="width: 10%;">
									<col style="width: 40%;">
									<col style="width: 25%;">
									<col style="width: 25%;">
								</colgroup>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" name="pass"></td>
									<td class="text-left"><button type="submit"
											action="delete">삭제</button></td>
									<input type='hidden' name="action" value="delete">
									<input type='hidden' name="no" value="${no}">
									<td><a
										href="http://localhost:8080/mysite3/user?action=loginForm">[메인으로
											돌아가기]</a></td>
								</tr>
							</table>
							<input type='hidden' name="action" value="main">
						</form>

					</div>
					<!-- //guestbook -->
				</div>
				<!-- //content  -->

			</div>
			<!-- //container  -->

			<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
			<!-- //footer -->

		</div>
		<!-- //wrap -->
	</div>
</body>

</html>
